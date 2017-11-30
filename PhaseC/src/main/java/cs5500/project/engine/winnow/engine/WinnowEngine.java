package cs5500.project.engine.winnow.engine;

import cs5500.project.engine.GlobalConstants;
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
    int k = GlobalConstants.K_GRAM;
    int q = GlobalConstants.PRIME;
    int radix = 256;
    int line_number = 1;

    int highOrder = (int) (Math.pow(radix, k - 1) % q);

    String[] lines = content.split("\n");

    int index = 0;

    int line_count = 1;

    for (String line : lines) {
      // this was a blank line and is only useful for the purpose of maintaining line number
      // count, the text '$' has otherwise no other significance.
      if (line.contains("$")) {
        line_count += 1;
        continue;
      }

      //calc length of line
      int line_length = line.length();

      HashRange index_range = new HashRange(index, index + line.length() - 1);
      span_store.add(new HashIndex(index_range, line_count));
      index = index + line_length;
      line_count += 1;
    }

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



