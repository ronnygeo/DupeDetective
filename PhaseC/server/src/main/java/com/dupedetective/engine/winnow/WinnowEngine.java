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

  /**
   * @param content the file content
   */
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

  /**
   * Based on HashCode and Window Size, this method generates Code fingerPrint
   */
  private void generateCodeFingerPrint() {
    int element = 0;
    int hashIndex = -1;
    LineIndex minHash = kGramHash.get(0);
    List<LineIndex> window;

    while (element < kGramHash.size()) {

      if (hashIndex < 0) {
        if (element == 0) {
          window = kGramHash.subList(0, GlobalConstants.WINDOW_SIZE);
          element += GlobalConstants.WINDOW_SIZE;
        } else {
          window = kGramHash
              .subList(element - (GlobalConstants.WINDOW_SIZE - 1),
                  element + 1);
          element += 1;
        }

        //find the minimum element in the window with its index
        minHash = window.get(0);

        for (int index = 0; index < window.size(); index++) {
          if (window.get(index).value <= minHash.value) {
            minHash = window.get(index);
            hashIndex = index;
          }
        }
        fingerPrint.add(minHash);
      } else {
        if (kGramHash.get(element).value <= minHash.value) {
          minHash = kGramHash.get(element);
          fingerPrint.add(minHash);
          hashIndex = GlobalConstants.WINDOW_SIZE - 1;
        }
        element += 1;
      }
      hashIndex -= 1;
    }
  }

  /**
   * Calculate Hash of file content
   */
  private void calculateHash() {
    int k = GlobalConstants.N_GRAM;
    int weight = getWeight();
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
      hashCode = calcHashCode(hashCode - content.charAt(c) * weight, content.charAt(c + k));

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

  /**
   * Stores a map of lineLength and lineSpan
   */
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
   * @return Weight to ensure proper normalization of hash calculation
   */
  private int getWeight() {
    return (int) (Math.pow(GlobalConstants.RADIX, GlobalConstants.N_GRAM - 1)
        % GlobalConstants.PRIME);
  }

  /**
   *
   * @param weight weight
   * @param constant constant
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
   * get line number
   * @param index index of line
   * @return Line Number in the hash for that index
   */
  private int getLineNumber(int index) {
    int start = 0;
    int end = this.lineIndex.size() - 1;
    int lineNumber = -1;
    // Use Binary search to find line number from lineIndex
    while (start <= end) {

      int mid = (start + end) / 2;

      LineIndex li = lineIndex.get(mid);

      if (li.getRange().getStart() <= index && index <= li.getRange().getEnd()) {
        lineNumber = li.value;
        break;
      } else if (index < li.getRange().getStart()) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return lineNumber;
  }

  /**
   * Custom class for keeping in check value(line_number/hashCode) and range
   */
  public class LineIndex {

    int value;
    Range range;

    /**
     * @param range range of line
     * @param number line number
     */
    public LineIndex(Range range, int number) {
      this.range = range;
      this.value = number;
    }

    /**
     * @return the value
     */
    public int getValue() {
      return value;
    }

    /**
     * @return the range
     */
    public Range getRange() {
      return range;
    }
  }

  /**
   * Custom Range class to keep track of starting and end index of lines in file
   */
  public class Range {

    int start;
    int end;

    /**
     * @param start start of range
     * @param end end of range
     */
    public Range(int start, int end) {
      this.start = start;
      this.end = end;
    }

    /**
     * @return the start
     */
    public int getStart() {
      return start;
    }

    /**
     * @return the end
     */
    public int getEnd() {
      return end;
    }
  }

}