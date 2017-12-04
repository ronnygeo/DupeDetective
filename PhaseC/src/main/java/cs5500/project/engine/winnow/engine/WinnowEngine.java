package cs5500.project.engine.winnow.engine;

import cs5500.project.engine.GlobalConstants;
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
   * @return
   */
  public List<LineIndex> getFingerPrint() {

    populateLineSpan();

    filterContent();

    calculateHash();

    stub();

    return fingerPrint;
  }

  private void stub() {
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
          if (window.get(index).lineNumber <= minimum_hash.lineNumber) {
            minimum_hash = window.get(index);
            hash_relative_index = index;
          }
        }
        fingerPrint.add(minimum_hash);
      } else {
        //check if the new element added to the window is lesser or equal
        if (kGramHash.get(processed_element).lineNumber <= minimum_hash.lineNumber) {
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
    int begin_line = find_line(0);
    int end_line = find_line(k);

    LineRange line_span = new LineRange(begin_line, end_line);

    for (int c = 0; c < k; c++) {
      hashCode = calcHashCode(hashCode, content.charAt(c));
    }
    kGramHash.add(new LineIndex(line_span, hashCode));

    for (int c = 0; c < (cLen - k); c++) {
      hashCode = calcHashCode(hashCode - content.charAt(c) * highOrder, content.charAt(c + k));

      begin_line = find_line(c + 1);
      end_line = find_line(c + k);

      line_span = new LineRange(begin_line, end_line);

      kGramHash.add(new LineIndex(line_span, hashCode));
    }

  }

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
      LineRange range = new LineRange(index, index + line.length() - 1);
      lineIndex.add(new LineIndex(range, totalLines));
      index = index + line.length();
      totalLines++;
    }
  }

  private int getHighOrder() {
    return (int) (Math.pow(GlobalConstants.RADIX, GlobalConstants.N_GRAM - 1)
        % GlobalConstants.PRIME);
  }

  private int calcHashCode(int weight, int constant) {
    int n = GlobalConstants.RADIX * weight + constant;
    int p = GlobalConstants.PRIME;

    int hashCode = n % p;

    if (hashCode < 0) {
      hashCode += p;
    }

    return hashCode;
  }

  private int find_line(int index) {
    int begin_index = 0;
    int end_index = this.lineIndex.size() - 1;

    while (begin_index <= end_index) {

      int mid = (begin_index + end_index) / 2;

      LineIndex index_object = lineIndex.get(mid);

      if (index_object.range.start <= index && index <= index_object.range.end) {
        return index_object.lineNumber;
      } else if (index < index_object.range.start) {
        end_index = mid - 1;
      } else {
        begin_index = mid + 1;
      }
    }

    return -1;
  }

  /**
   * Custom class for keeping in check range and line_number
   */
  public class LineIndex {

    int lineNumber;
    LineRange range;

    public int getLineNumber() {
      return lineNumber;
    }

    public LineRange getRange() {
      return range;
    }

    public LineIndex(LineRange range, int number) {
      this.range = range;
      this.lineNumber = number;
    }


  }

  /**
   * Custom Range class to keep track of starting and end index
   */
  public class LineRange {

    int start;
    int end;

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }

    public LineRange(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

}