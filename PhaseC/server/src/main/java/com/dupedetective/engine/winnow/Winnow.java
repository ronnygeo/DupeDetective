package com.dupedetective.engine.winnow;

import com.dupedetective.data.ReportLine;
import com.dupedetective.engine.Model;
import com.dupedetective.engine.winnow.WinnowEngine.LineIndex;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author Joyal Winnow class implements winnowing strategy to detect plagiarism between two java
 * files
 */
public class Winnow {

  final static Logger logger = Logger.getLogger(Winnow.class);

  // Data of java file under suspect
  String srcFileData;
  // Data of java file from whom suspect might have plagiarised
  String dstFileData;
  // Normalised src file
  String normalisedSrcFile;
  // Normalised dest file
  String normalisedDestFile;
  // Source fingerprint
  List<LineIndex> sfp;
  // Destination code fingerprint
  List<LineIndex> dfp;
  // Similarity Rate
  float similarity;

  public Winnow() {
    sfp = new ArrayList<>();
    dfp = new ArrayList<>();
    similarity = 0f;
  }

  public Winnow(String fileData1, String fileData2) {
    this();
    this.srcFileData = fileData1;
    this.dstFileData = fileData2;
  }

  // Getter for similarity
  public float getSimilarity() {
    return similarity;
  }

  /**
   * Calculates Similarity Rate for source and destination files
   */
  public void calcSimilarityRate() {

    normaliseData();
    if (!StringUtils.isEmpty(normalisedSrcFile) && !StringUtils.isEmpty(normalisedDestFile)) {
      populateFingerPrint();
      if (sfp.size() > 0 || dfp.size() > 0) {
        similarity = getIntersection() / getUnion();
      }
    }

  }

  /**
   * Gets fingerprint for both source and destination codes
   */
  private void populateFingerPrint() {
    WinnowEngine srcEngine = new WinnowEngine(normalisedSrcFile);
    WinnowEngine dstEngine = new WinnowEngine(normalisedDestFile);
    sfp = srcEngine.getFingerPrint();
    dfp = dstEngine.getFingerPrint();
  }

  /**
   * Normalise both the files 1. Lower Case for files 2. Remove Comments 3. Remove Space Tokens 4.
   * Replace Identifiers 5. Remove Keywords 6. Remove Punctuations 7. Remove WhiteSpaces
   */
  private void normaliseData() {
    normalisedSrcFile = normaliseFile(srcFileData);
    normalisedDestFile = normaliseFile(dstFileData);
  }

  /**
   * @return Union of all hash values of both the codes's fingerprints
   */
  private int getUnion() {
    Set<Integer> union = new HashSet<>();
    for (LineIndex li : sfp) {
      union.add(li.getValue());
    }
    for (LineIndex li : dfp) {
      union.add(li.getValue());
    }
    return union.size();
  }

  /**
   * @return Intersection of all hash values of both the codes's fingerprints
   */
  private float getIntersection() {
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
      if (list2.contains(t)) {
        list.add(t);
      }
    }
    return (float) list.size();
  }

  /**
   * Given file data, the function parses the code file and gets a filtered version of the file
   * where following semantics of file are modified 1. Lower Case for files 2. Remove Comments 3.
   * Remove Space Tokens 4. Replace Identifiers 5. Remove Keywords 6. Remove Punctuations 7. Remove
   * WhiteSpaces
   *
   * @param fileData file data
   */
  private String normaliseFile(String fileData) {
    return new NormalisedFile(fileData).getNormalisedFile();
  }

  /**
   * @return List of ReportLine to be used to highlight plagiarised code in front end
   */
  public List<ReportLine> getReport() {
    List<ReportLine> l = new ArrayList<>();
    ReportLine ri = new ReportLine();
    ri.setModel(Model.WINNOWING.getValue());
    ri.setScore(getSimilarity());
    l.add(ri);
    return l;
  }
}
