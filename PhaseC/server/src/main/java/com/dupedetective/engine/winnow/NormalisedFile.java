package com.dupedetective.engine.winnow;

import com.dupedetective.engine.GlobalConstants;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * This class normalises a given file
 * @author Joyal
 */
public class NormalisedFile {

  /**
   * @return get file content
   */
  public String getFileContents() {
    return fileContents;
  }

  /**
   * @return get normalized file content
   */
  public StringBuilder getNormalisedFileContents() {
    return normalisedFileContents;
  }

  // Actual file content
  String fileContents;
  // Normalised file content
  StringBuilder normalisedFileContents;

  /**
   * @param fileContents file contents
   */
  public NormalisedFile(String fileContents){
    this.fileContents = fileContents;
    this.normalisedFileContents = new StringBuilder();
  }

  /**
   * This method updates semantics of file for winnowing strategy and gets normalised content of
   * file
   * @return normalised content of file
   */
  public String getNormalisedFile() {

    // change file content to lowercase
    changeToLowerCase();

    // remove comments from file
    removeFileComments();

    // identify keywords and tokenize
    tokenizeKeywords();

    // replace identifiers
    replaceIdentifiers();

    // remove keywords
    removeKeywords();

    // remove punctuations
    removePunctuations();

    // replace new line
    replaceLineBreak();

    return getNormalisedFileContents().toString();
  }

  /**
   * Replace all line breaks with $ symbol
   */
  public void replaceLineBreak() {
    String[] lines = getLineOfContents();

    for(String line : lines) {
      line = line.replaceAll("\t","");
      line = line.replaceAll(" ","");
      if(StringUtils.isEmpty(line)){
        line="$";
      }
      normalisedFileContents.append(line).append("\n");
    }
  }

  /**
   * Remove all punctuations
   */
  public void removePunctuations() {
    String[] lines = getLineOfContents();

    for(String line : lines) {
      line= line.replaceAll(",", "");
      line= line.replaceAll(";", "");
      line= line.replaceAll("\\{", "");
      line= line.replaceAll("}", "");
      line= line.replaceAll("\\[", "");
      line= line.replaceAll("]", "");
      line= line.replaceAll("\\)", "");
      line= line.replaceAll("\\(", "");
      line= line.replaceAll(":", "");
      line= line.replace(".", "");
      line= line.replaceAll("\"", "");
      normalisedFileContents.append(line).append("\n");
    }

    setContent();
  }

  /**
   * Removes keywords after identifiers
   */
  public void removeKeywords() {
    String[] lines = getLineOfContents();
    List<String> javaKeywords = GlobalConstants.JAVA_KEYWORDS;
    for (String line : lines) {
      for (String keyword : javaKeywords) {
        //Remove multiple occurrences of keyword in line
        line = line.replaceAll(keyword, "");
      }
      normalisedFileContents.append(line).append("\n");
    }
    setContent();
  }

  /**
   * 1. replace identifiers with v
   * 2. skip import lines
   * 3. skip function calls
   */
  public void replaceIdentifiers() {
    String[] lines = getLineOfContents();
    List<String> noIdentifier = GlobalConstants.NO_IDENTIFIER;
    List<String> javaKeywords = GlobalConstants.JAVA_KEYWORDS;
    for (String line : lines) {
      line = line.trim();
      String[] line_split = line.split(" ");
      if (line_split.length > 0) {
        String new_line = "";
        boolean text_modified = false;

        // change all the words that are "identifier" by regex to 'v'
        if (!noIdentifier.contains(line_split[0])) {
          text_modified = true;
          for (String word : line_split) {
            if (!StringUtils.isEmpty(word)) {
              // First regex for a word which begins with a-z or _ and then has any word(w) and then does not end with )
              // We did not consider A-Z coz we have already lowercased our text
              // Second regex for just a single length word indentifier
              if (word.matches("^[a-z|_]\\w*[^\\(]$") != false
                  || word.matches("^[a-z]$") != false) {
                //puts word
                //unless the keyword list contains this word
                if (!javaKeywords.contains(word)) {
                  word = word.replace(word, "v");
                }
              }
              new_line += " " + word + " ";
            }
          }
        }

        if (text_modified) {
          normalisedFileContents.append(new_line).append("\n");
        } else {
          normalisedFileContents.append(line).append("\n");
        }
      }
    }
    setContent();
  }

  /**
   * Tokenises Keywords
   */
  public void tokenizeKeywords() {
    String[] lines = getLineOfContents();
    List<String> javaKeywords = GlobalConstants.JAVA_KEYWORDS;

    for (String line : lines) {
      String[] line_split = line.split(" ");
      line = "";

      for (String word : line_split) {
        for (String keyword : javaKeywords) {
          if (word.contains(keyword)) {
            String new_keyword = " " + keyword + " ";
            word = word.replace(keyword, new_keyword);
          }
        }
        line += word;
      }
      // Space 'commas' and semicolon
      line = line.replaceAll(",", " , ");
      line = line.replaceAll(";", " ; ");
      line = line.replaceAll("\\{", " { ");
      line = line.replaceAll("}", " } ");
      line = line.replaceAll("\\[", " [ ");
      line = line.replaceAll("]", " ] ");
      line = line.replaceAll("\\(", "( "); //keep attached to method but seperate from parameter within
      line = line.replaceAll("\\)", " ) ");
      line = line.replaceAll("\\+", " + "); //Case when c++ c + +
      line = line.replaceAll("-", " - ");
      // For all words with =,:,<,> sticked together we can separate the
      // identifier.methodname() or identifier:list with a space so as they
      // can be later properly identified as a separate variable
      // We need them at this stage to differentiate between different tokens,
      // so they will be removed in a later stage
      line = line.replaceAll("=", " = ");
      line = line.replaceAll(":", " : ");
      line = line.replaceAll("<", " < ");
      line = line.replaceAll(">", " > ");
      line = line.replace(".", ". ");

      //Remove @
      line = line.replaceAll("@", "");

      normalisedFileContents.append(line);
      normalisedFileContents.append("\n");
    }
    setContent();
  }

  /**
   * This function removes both single line and multi line comments from file
   */
  public void removeFileComments() {
    List<String> singleLineComment = GlobalConstants.SINGLE_LINE_COMMENT;
    List<String> multiLineComment = GlobalConstants.MULTI_LINE_COMMENT;

    boolean isMultiLine = false;
    boolean hasSingleLineComment;

    String[] lines = getLineOfContents();

    for (String line : lines) {

      // Set hasSingleLineComment to false for each iteration
      hasSingleLineComment = false;

      // remove leading/trailing white-spaces from line
      line = removeWhiteSpace(line);

      // check whether multi line has been encountered
      if (isMultiLine) {
        // check end of multiline
        if (line.contains(GlobalConstants.MULTI_LINE_END)) {
          isMultiLine = false;
          continue; // skip current line and execute next iteration
        } else {
          continue; // skip current line and execute next iteration
        }
      }

      // check if line begins with any single line comment
      for (String comment : singleLineComment) {
        if (comment.length() <= line.length()) {
          // if substring of line till comment-length equals comment
          if (line.substring(0, comment.length()).equals(comment)) {
            hasSingleLineComment = true;
            break;
          }
        }
        // check if comment is in somewhere in middle of line
        if (line.contains(comment)) {
          // get part of line till comment
          line = line.substring(line.indexOf(comment), line.length());
        }
      }

      // check for line containing multi line comment
      for (String comment : multiLineComment) {
        if (comment.length() <= line.length()) {
          if (line.substring(0, comment.length()).equals(comment)) {
            isMultiLine = true;
          }
        }
      }

      if (!hasSingleLineComment && !isMultiLine) {
        normalisedFileContents.append(line);
      }

      normalisedFileContents.append("\n");
    }
    setContent();
  }

  /**
   * Given a line, it removes all leading/trailing white-space
   * @param line line from where white spaces are to be removed
   * @return Line
   */
  public String removeWhiteSpace(String line) {
    return line.replaceAll(GlobalConstants.REGEX_WHITESPACE, " ").trim();
  }

  /**
   * @return contents of file in lines
   */
  public String[] getLineOfContents() {
    String[] output = null;
    if (!StringUtils.isEmpty(fileContents)) {
      output = fileContents.split("\n");
    }
    return output;
  }

  /**
   * This function reads file contents line by line and sets all its content to lower case
   */
  public void changeToLowerCase() {
    String[] lines = fileContents.split("\n");
    for (String line : lines) {
      normalisedFileContents.append(line.toLowerCase());
      normalisedFileContents.append("\n");
    }
    setContent();
  }

  /**
   * Updates fileContents to normalisedFileContents for further use
   */
  public void setContent() {
    fileContents = normalisedFileContents.toString();
    // clear normalised content
    normalisedFileContents = new StringBuilder();
  }
}
