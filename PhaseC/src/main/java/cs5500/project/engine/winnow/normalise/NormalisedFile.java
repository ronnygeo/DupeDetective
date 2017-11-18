package cs5500.project.engine.winnow.normalise;

import cs5500.project.engine.GlobalConstants;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * This class normalises a given file
 * @author Joyal
 */
public class NormalisedFile {

  // Actual file content
  String fileContents;
  // Normalised file content
  StringBuilder normalisedFileContents;

  public NormalisedFile(String filePath) throws IOException {
    fileContents = readFileAsString(filePath);
    normalisedFileContents = new StringBuilder();
  }

  /**
   * @param filePath absolute path of file
   * @return file content at filePath as String
   * @throws IOException
   */
  private String readFileAsString(String filePath) throws IOException {
    return new String(Files.readAllBytes(Paths.get(filePath)));
  }

  /**
   * This method updates semantics of file winnowing strategy
   * and gets normalised content of file
   * @return normalised content of file
   */
  public String getNormalisedFile() {

    // change file content to lowercase
    changeToLowerCase();

    // remove comments from file
    removeFileComments();

    return normalisedFileContents.toString();
  }

  /**
   * This function removes both single line and multi line comments from file
   */
  private void removeFileComments() {
    List<String> singleLineComment = GlobalConstants.SINGLE_LINE_COMMENT;
    List<String> multiLineComment = GlobalConstants.MULTI_LINE_COMMENT;

    String[] lines = getLineOfContents();
  }

  /**
   * @return contents of file in lines
   */
  private String[] getLineOfContents() {
    String[] output = null;
    if(!StringUtils.isEmpty(fileContents)){
      return fileContents.split("\n");
    }
    return output;
  }

  /**
   * This function reads file contents line by line
   * and sets all its content to lower case
   */
  private void changeToLowerCase() {
    String[] lines = fileContents.split("\n");
    for (String line : lines) {
      normalisedFileContents.append(line.toLowerCase());
      normalisedFileContents.append("\n");
    }
    setContent();
  }

  /**
   * Updates fileContents to normalisedFileContents
   * for further use
   */
  private void setContent() {
    fileContents = normalisedFileContents.toString();
    // clear normalised content
    normalisedFileContents = new StringBuilder();
  }
}
