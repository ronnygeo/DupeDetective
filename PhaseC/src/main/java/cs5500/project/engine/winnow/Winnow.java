package cs5500.project.engine.winnow;

import cs5500.project.engine.winnow.normalise.NormalisedFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Joyal
 * Winnow class implements winnowing strategy
 * to detect plagiarism between two java files
 */
public class Winnow {

  // Path of java file under suspect
  String srcFilePath;
  // Path of java file from whom suspect might have plagiarised
  String dstFilePath;
  // Normalised src file
  String normalisedSrcFile;
  // Normalised dest file
  String normalisedDestFile;

  public Winnow(String path1,String path2){
    srcFilePath = path1;
    dstFilePath = path2;
  }

  /**
   * @return similarity rate
   */
  public float getSimilarity() {
    float similarity = 0f;

    try{

      // Normalise both the files
      // 1. Lower Case for files
      // 2. Remove Comments
      // 3. Remove Space Tokens
      // 4. Replace Identifiers
      // 5. Remove Keywords
      // 6. Remove Punctuations
      // 7. Remove WhiteSpaces
      normalisedSrcFile = normaliseFile(srcFilePath);
      normalisedDestFile = normaliseFile(dstFilePath);

      if(!StringUtils.isEmpty(normalisedSrcFile) && !StringUtils.isEmpty(normalisedDestFile)){
        
      }
    }
    catch(IOException ex){
      // Todo Implement Logging
      ex.printStackTrace();
    }
    catch(Exception ex){
        // Todo Implement Logging
        ex.printStackTrace();
    }

    return similarity;
  }

  /**
   * Given a filePath, the function parses the code file
   * and gets a filtered version of the file where following
   * semantics of file are modified
   * 1. Lower Case for files
   * 2. Remove Comments
   * 3. Remove Space Tokens
   * 4. Replace Identifiers
   * 5. Remove Keywords
   * 6. Remove Punctuations
   * 7. Remove WhiteSpaces
   * @param filePath absolute path of file
   * @throws FileNotFoundException
   */
  private String normaliseFile(String filePath) throws IOException {
    String normalisedFile = new NormalisedFile(filePath).getNormalisedFile();
    return normalisedFile;
  }

}
