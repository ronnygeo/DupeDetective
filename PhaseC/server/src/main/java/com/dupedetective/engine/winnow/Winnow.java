package com.dupedetective.engine.winnow;

<<<<<<< HEAD:PhaseC/src/main/java/cs5500/project/engine/winnow/Winnow.java
import cs5500.project.engine.winnow.engine.WinnowEngine;
import cs5500.project.engine.winnow.engine.WinnowEngine.LineIndex;
import cs5500.project.engine.winnow.engine.WinnowEngine.Range;
import cs5500.project.engine.winnow.normalise.NormalisedFile;
=======
import com.dupedetective.engine.winnow.engine.WinnowEngine;
import com.dupedetective.engine.winnow.normalise.NormalisedFile;
import java.io.FileNotFoundException;
>>>>>>> 29d6ab18561b310a62fa78f02f905761b763db43:PhaseC/server/src/main/java/com/dupedetective/engine/winnow/Winnow.java
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Joyal Winnow class implements winnowing strategy to detect plagiarism between two java
 * files
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

  public Winnow(String path1, String path2) {
    srcFilePath = path1;
    dstFilePath = path2;
  }

  /**
   * @return similarity rate
   */
  public float getSimilarity() {
    float similarity = 0f;

    try {

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
      
      if (!StringUtils.isEmpty(normalisedSrcFile) && !StringUtils.isEmpty(normalisedDestFile)) {
        WinnowEngine srcEngine = new WinnowEngine(normalisedSrcFile);
        WinnowEngine dstEngine = new WinnowEngine(normalisedDestFile);

        List<LineIndex> sfp = srcEngine.getFingerPrint();
        List<LineIndex> dfp = dstEngine.getFingerPrint();

        if (sfp.size() > 0 || dfp.size() > 0) {
          similarity = getIntersection(sfp, dfp) / getUnion(sfp, dfp);
        }

      }
    } catch (IOException ex) {
      // Todo Implement Logging
      ex.printStackTrace();
    } catch (Exception ex) {
      // Todo Implement Logging
      ex.printStackTrace();
    }

    return similarity;
  }

  private int getUnion(List<LineIndex> sfp, List<LineIndex> dfp) {
    Set<Integer> union = new HashSet<>();

    for (LineIndex li : sfp) {
      union.add(li.getValue());
    }

    for (LineIndex li : dfp) {
      union.add(li.getValue());
    }
    return union.size();
  }

  private float getIntersection(List<LineIndex> sfp, List<LineIndex> dfp) {
    float intersection = 0;

    Map<Integer, Range> common = new HashMap<>();

    for (LineIndex li : sfp) {
      common.put(li.getValue(), li.getRange());
    }

    for (LineIndex li : dfp) {
      if (common.containsKey(li.getValue())) {
        intersection++;
      }
    }

    return intersection;
  }

  /**
   * Given a filePath, the function parses the code file and gets a filtered version of the file
   * where following semantics of file are modified 1. Lower Case for files 2. Remove Comments 3.
   * Remove Space Tokens 4. Replace Identifiers 5. Remove Keywords 6. Remove Punctuations 7. Remove
   * WhiteSpaces
   *
   * @param filePath absolute path of file
   */
  private String normaliseFile(String filePath) throws IOException {
    String normalisedFile = new NormalisedFile(filePath).getNormalisedFile();
    return normalisedFile;
  }

}
