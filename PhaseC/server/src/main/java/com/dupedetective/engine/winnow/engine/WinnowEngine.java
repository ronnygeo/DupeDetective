package com.dupedetective.engine.winnow.engine;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Detects plagiarism based on winnowing
 */
public class WinnowEngine {

  String content;
  LinkedHashMap fingerPrint;
  List<HashIndex> span_store;

  public WinnowEngine(String content) {
    this.content = content;
    this.fingerPrint = new LinkedHashMap();
    this.span_store = new ArrayList<>();
  }

  /**
   * @return
   */
  public LinkedHashMap getFingerPrint() {
    LinkedHashMap hashStore = calculateHash();
    return fingerPrint;
  }

  /**
   * Calculate Hash of file content
   *
   * @return Hash of file
   */
  private LinkedHashMap calculateHash() {
    return fingerPrint;
  }

  /**
   * Custom class for keeping in check range and line_number
   */
  private class HashIndex {

    HashRange index_range;
    int line_number;

    public HashIndex(HashRange index_range, int line_number) {
      this.index_range = index_range;
      this.line_number = line_number;
    }
  }

  /**
   * Custom Range class to keep track of starting
   * and end index
   */
  private class HashRange {

    int start;
    int end;

    public HashRange(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}



