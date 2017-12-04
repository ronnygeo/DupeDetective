package com.dupedetective.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GlobalConstants {
  public static final List<String> SINGLE_LINE_COMMENT = new ArrayList<>(Arrays.asList("//"));
  public static final List<String> MULTI_LINE_COMMENT = new ArrayList<>(Arrays.asList("/*","/**"));
  public static final List<String> JAVA_KEYWORDS = new ArrayList<>(Arrays.asList("abstract","assert","boolean","break","byte","case","catch","char","class","const","continue","default","do","double","else","enum","extends","final","finally","float","for","FALSE","goto","if","implements","import","instanceof","int","interface","long","native","new","package","private","protected","public","return","short","static","strictfp","super","switch","synchronized","this","throw","throws","transient","try","void","volatile","while","String","System"));
  public static final List<String> NO_IDENTIFIER = new ArrayList<>(Arrays.asList("import","package"));
  public static final String REGEX_WHITESPACE = "\\s";
  public static final String MULTI_LINE_END = "*/";
  public static final int K_GRAM = 5;
  public static final int THRESHOLD = 8;
  public static final int PRIME = 10001;
}