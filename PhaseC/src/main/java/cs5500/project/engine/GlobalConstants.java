package cs5500.project.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GlobalConstants {
  public static final List<String> SINGLE_LINE_COMMENT = new ArrayList<>(Arrays.asList("//"));
  public static final List<String> MULTI_LINE_COMMENT = new ArrayList<>(Arrays.asList("/*","/**"));
  public static final String REGEX_WHITESPACE = "\\s";
}
