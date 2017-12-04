package com.dupedetective.engine;

import com.dupedetective.data.ReportLine;
import com.dupedetective.engine.winnow.Winnow;
import java.util.ArrayList;
import java.util.List;

/**
 * Winnow Strategy for plagiarism detection
 */
public class WinnowStrategy implements PDStrategy{

  @Override
  public List<ReportLine> checkPlagiarism(String code1, String code2) {
    List<ReportLine> l = new ArrayList<>();
    ReportLine ri = new ReportLine();
    ri.setModel(Model.WINNOWING.getValue());
    ri.setScore(ImplementWinnow(code1,code2));
    l.add(ri);
    return l;
  }

  /**
   * Implement winnow strategy to determine code similarity
   * @param code1 First code to check
   * @param code2 Second code to check
   * @return Similarity Rate between the two codes
   */
  private Float ImplementWinnow(String code1, String code2) {
    return new Winnow(code1, code2).getSimilarity();
  }
}
