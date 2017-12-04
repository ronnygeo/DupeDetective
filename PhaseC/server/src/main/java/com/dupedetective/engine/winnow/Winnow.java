package com.dupedetective.engine.winnow;

import com.dupedetective.engine.winnow.WinnowEngine.LineIndex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Joyal Winnow class implements winnowing strategy to detect plagiarism between two java
 * files
 */
public class Winnow {

  // Data of java file under suspect
  String srcFileData;
  // Data of java file from whom suspect might have plagiarised
  String dstFileData;
  // Normalised src file
  String normalisedSrcFile;
  // Normalised dest file
  String normalisedDestFile;

  public Winnow(String fileData1, String fileData2) {
    this.srcFileData = fileData1;
    this.dstFileData = fileData2;
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
      normalisedSrcFile = normaliseFile(srcFileData);
      normalisedDestFile = normaliseFile(dstFileData);
      
      if (!StringUtils.isEmpty(normalisedSrcFile) && !StringUtils.isEmpty(normalisedDestFile)) {
        WinnowEngine srcEngine = new WinnowEngine(normalisedSrcFile);
        WinnowEngine dstEngine = new WinnowEngine(normalisedDestFile);

        List<LineIndex> sfp = srcEngine.getFingerPrint();
        List<LineIndex> dfp = dstEngine.getFingerPrint();

        if (sfp.size() > 0 || dfp.size() > 0) {
          similarity = getIntersection(sfp, dfp) / getUnion(sfp, dfp);
        }

      }
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
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    for (LineIndex li : sfp) {
      list1.add(li.getValue());
    }
    for (LineIndex li : dfp) {
      list2.add(li.getValue());
    }
    Set<Integer> list = new HashSet<>();
    for (Integer t : list1) {
      if(list2.contains(t)) {
        list.add(t);
      }
    }
    return (float)list.size();
  }

  /**
   * Given file contents, the function parses the code file and gets a filtered version of the file
   * where following semantics of file are modified 1. Lower Case for files 2. Remove Comments 3.
   * Remove Space Tokens 4. Replace Identifiers 5. Remove Keywords 6. Remove Punctuations 7. Remove
   * WhiteSpaces
   *
   * @param fileContents content of code file
   */
  private String normaliseFile(String fileContents){
    return new NormalisedFile(fileContents).getNormalisedFile();
  }

}
