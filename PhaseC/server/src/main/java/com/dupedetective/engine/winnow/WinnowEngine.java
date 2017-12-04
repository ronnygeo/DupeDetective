package com.dupedetective.engine.winnow;

import com.dupedetective.engine.GlobalConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Detects plagiarism based on winnowing
 */
public class WinnowEngine {

  String content;
  List<LineIndex> fingerPrint;
  List<LineIndex> kGramHash;
  List<LineIndex> lineIndex;

  public WinnowEngine(String content) {
    this.content = content;
    this.fingerPrint = new ArrayList<>();
    this.kGramHash = new ArrayList<>();
    this.lineIndex = new ArrayList<>();
  }

  /**
   * @return code fingerprint
   */
  public List<LineIndex> getFingerPrint() {

    populateLineSpan();

    filterContent();

    calculateHash();

    generateCodeFingerPrint();

    return fingerPrint;
  }

  private void generateCodeFingerPrint() {
    int processed_element = 0;
    int hash_relative_index = -1;
    LineIndex minimum_hash = kGramHash.get(0);
    List<LineIndex> window;

    while (processed_element < kGramHash.size()) {

      if (hash_relative_index < 0) { //A new window span to begin
        if (processed_element == 0) {
          window = kGramHash.subList(0, GlobalConstants.WINDOW_SIZE);
          processed_element += GlobalConstants.WINDOW_SIZE;
        } else {
          window = kGramHash
              .subList(processed_element - (GlobalConstants.WINDOW_SIZE - 1), processed_element+1);
          processed_element += 1;
        }

        //find the minimum element in the window with its index
        minimum_hash = window.get(0);

        for (int index = 0; index < window.size(); index++) {
          if (window.get(index).value <= minimum_hash.value) {
            minimum_hash = window.get(index);
            hash_relative_index = index;
          }
        }
        fingerPrint.add(minimum_hash);
      } else {
        //check if the new element added to the window is lesser or equal
        if (kGramHash.get(processed_element).value <= minimum_hash.value) {
          minimum_hash = kGramHash.get(processed_element);
          fingerPrint.add(minimum_hash);
          hash_relative_index = GlobalConstants.WINDOW_SIZE - 1;
        }
        processed_element += 1;
      }
      hash_relative_index -= 1;
    }
  }

  /**
   * Calculate Hash of file content
   */
  private void calculateHash() {
    int k = GlobalConstants.N_GRAM;
    int highOrder = getHighOrder();
    int cLen = content.length();
    int hashCode = 0;
    int begin_line = getLineNumber(0);
    int end_line = getLineNumber(k);

    Range line_span = new Range(begin_line, end_line);

    for (int c = 0; c < k; c++) {
      hashCode = calcHashCode(hashCode, content.charAt(c));
    }
    kGramHash.add(new LineIndex(line_span, hashCode));

    for (int c = 0; c < (cLen - k); c++) {
      hashCode = calcHashCode(hashCode - content.charAt(c) * highOrder, content.charAt(c + k));

      begin_line = getLineNumber(c + 1);
      end_line = getLineNumber(c + k);

      line_span = new Range(begin_line, end_line);

      kGramHash.add(new LineIndex(line_span, hashCode));
    }

  }

  /**
   * Remove new line and dollar character
   */
  private void filterContent() {
    content = content.replaceAll("\n", "");
    content = content.replace("$", "");
  }

  private void populateLineSpan() {
    String[] lines = content.split("\n");
    int index = 0;
    int totalLines = 1;
    for (String line : lines) {
      if (line.contains("$")) {
        totalLines++;
        continue;
      }
      Range range = new Range(index, index + line.length() - 1);
      lineIndex.add(new LineIndex(range, totalLines));
      index = index + line.length();
      totalLines++;
    }
  }

  /**
   * @return
   */
  private int getHighOrder() {
    return (int) (Math.pow(GlobalConstants.RADIX, GlobalConstants.N_GRAM - 1)
        % GlobalConstants.PRIME);
  }

  /**
   * @param weight
   * @param constant
   * @return HashCode for given weight and constant
   */
  private int calcHashCode(int weight, int constant) {
    int n = GlobalConstants.RADIX * weight + constant;
    int p = GlobalConstants.PRIME;

    int hashCode = n % p;

    if (hashCode < 0) {
      hashCode += p;
    }

    return hashCode;
  }

  /**
   * @param index
   * @return Line Number in the hash for that index
   */
  private int getLineNumber(int index) {
    int start = 0;
    int end = this.lineIndex.size() - 1;

    // Use Binary search to find line number from lineIndex
    while (start <= end) {

      int mid = (start + end) / 2;

      LineIndex li = lineIndex.get(mid);

      if (li.range.start <= index && index <= li.range.end) {
        return li.value;
      } else if (index < li.range.start) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return -1;
  }

  /**
   * Custom class for keeping in check value(line_number/hashCode) and range
   */
  public class LineIndex {

    int value;
    Range range;

    public int getValue() {
      return value;
    }

    public Range getRange() {
      return range;
    }

    public LineIndex(Range range, int number) {
      this.range = range;
      this.value = number;
    }
  }

  /**
   * Custom Range class to keep track of starting and end index of lines in file
   */
  public class Range {

    int start;
    int end;

    public int getStart() { return start; }

    public int getEnd() {
      return end;
    }

    public Range(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

}