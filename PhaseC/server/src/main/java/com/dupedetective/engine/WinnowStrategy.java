package com.dupedetective.engine;

import com.dupedetective.data.ReportLine;
import com.dupedetective.engine.winnow.Winnow;

import java.util.List;

/**
 * Winnow Strategy for plagiarism detection
 */
public class WinnowStrategy implements PDStrategy{

  @Override
  public List<ReportLine> checkPlagiarism(String code1, String code2) {
    Winnow ngram = new Winnow(code1, code2);
    ngram.calcSimilarityRate();
    return ngram.getReport();
  }
}
