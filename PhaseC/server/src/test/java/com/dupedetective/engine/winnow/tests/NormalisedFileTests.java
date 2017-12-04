package com.dupedetective.engine.winnow.tests;

import static org.junit.Assert.assertEquals;

import com.dupedetective.engine.winnow.NormalisedFile;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Joyal Tests for checking whether a file has been normalised or not
 */
public class NormalisedFileTests {

  private String file1Path;
  private String file2Path;

  @Before
  public void setup() throws URISyntaxException {
    file1Path = getFilePath("testFile1.java");
    file2Path = getFilePath("testFile2.java");
  }
  private String getFilePath(String fileName) throws URISyntaxException {
    return Paths.get(getClass().getClassLoader().getResource(fileName).toURI()).toString();

  }

  @Test
  public void testLowerCase() {

    try {
      NormalisedFile nf = new NormalisedFile(file2Path);
      nf.changeToLowerCase();

      String expectedOutput = "package com.dupedetective.engine.winnow.tests.testfiles;\r\n"
          + "public class testfile2 {\r\n"
          + "    public static void main(string[] args){\r\n"
          + "        int i;\r\n"
          + "        string j;\r\n"
          + "        system.out.println(\"this text should be converted to lowercase\");\r\n"
          + "    }\r\n"
          + "}\n";

      String actualOutput = nf.getFileContents();
      assertEquals(expectedOutput, actualOutput);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testFileComments(){

    try {
      NormalisedFile nf = new NormalisedFile(file1Path);
      nf.removeFileComments();

      String expectedOutput = "package com.dupedetective.engine.winnow.tests.testfiles;\n"
          + "\n"
          + "\n"
          + "public class testFile1 {\n"
          + "\n"
          + "public static void main(String[] args){\n"
          + "\n"
          + "int i;\n"
          + "\n"
          + "System.out.println(\"When run for test, the output should not contain any comments\");\n"
          + "}\n"
          + "}\n";

      String actualOutput = nf.getFileContents();
      assertEquals(expectedOutput, actualOutput);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testTokeniseKeyword() {

    try {
      NormalisedFile nf = new NormalisedFile(file2Path);
      nf.tokenizeKeywords();
      String expectedOutput = " package com. dupedetective. engine. winnow. tests. testfiles ; \r\n"
          + " public  class testFile2 { \r\n"
          + " public  static  void main(  String  [  ] args )  { \r\n"
          + " int i ; \r\n"
          + " String j ; \r\n"
          + " System . out. pr int ln( \"THISTEXTSHOULDBECONVERTEDTOLOWERCASE\" )  ; \r\n"
          + " } \r\n"
          + " } \n";
      String actualOutput = nf.getFileContents();
      assertEquals(expectedOutput, actualOutput);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testReplaceIdentifiers() {

    try {
      NormalisedFile nf = new NormalisedFile(file1Path);
      nf.replaceIdentifiers();

      String expectedOutput = "package com.dupedetective.engine.winnow.tests.testfiles;\n"
          + "\n"
          + " /** \n"
          + " *  @author  Joyal \n"
          + " *  File  v  v  v  class  v  v \n"
          + " */ \n"
          + " public  class  v  { \n"
          + " //Initializing  v \n"
          + " public  static  void  main(String[]  args){ \n"
          + " //  v  v \n"
          + " int  v \n"
          + " //Print  Statement \n"
          + " System.out.println(\"When  v  for  v  v  v  v  v  v  v  comments\"); \n"
          + " } \n"
          + " } \n";
      String actualOutput = nf.getFileContents();
      assertEquals(expectedOutput, actualOutput);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testRemoveKeywords() {

    try {
      NormalisedFile nf = new NormalisedFile(file1Path);
      nf.removeKeywords();
      String expectedOutput = " com.dupedetective.engine.winnow.tests.testfiles;\r\n"
          + "\r\n"
          + "/**\r\n"
          + " * @author Joyal\r\n"
          + " * File comments is a  with comments\r\n"
          + " */\r\n"
          + "  testFile1 {\r\n"
          + "    //Initializing main\r\n"
          + "       main([] args){\r\n"
          + "        // variable declaration\r\n"
          + "         i;\r\n"
          + "        //Pr Statement\r\n"
          + "        .out.prln(\"When run  test, the output should not contain any comments\");\r\n"
          + "    }\r\n"
          + "}\r\n";
      String actualOutput = nf.getFileContents();
      assertEquals(expectedOutput, actualOutput);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testRemovePunctuations() {

    try {
      NormalisedFile nf = new NormalisedFile(file1Path);
      nf.removePunctuations();
      String expectedOutput = "package comdupedetectiveenginewinnowteststestfiles\r\n"
          + "\r\n"
          + "/**\r\n"
          + " * @author Joyal\r\n"
          + " * File comments is a class with comments\r\n"
          + " */\r\n"
          + "public class testFile1 \r\n"
          + "    //Initializing main\r\n"
          + "    public static void mainString args\r\n"
          + "        // variable declaration\r\n"
          + "        int i\r\n"
          + "        //Print Statement\r\n"
          + "        SystemoutprintlnWhen run for test the output should not contain any comments\r\n"
          + "    \r\n"
          + "\r\n";
      String actualOutput = nf.getFileContents();
      assertEquals(expectedOutput, actualOutput);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testGetNormalisedFile() {

    try {
      NormalisedFile nf = new NormalisedFile(file2Path);

      String expectedOutput = "comdupedetectiveenginewinnowteststestfiles\n"
          + "v\n"
          + "mainvv\n"
          + "v\n"
          + "v\n"
          + "vvvlnv\n"
          + "$\n"
          + "$\n";
      String actualOutput = nf.getNormalisedFile();

      assertEquals(expectedOutput, actualOutput);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}