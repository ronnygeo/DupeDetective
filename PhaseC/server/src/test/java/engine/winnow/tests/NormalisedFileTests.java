package engine.winnow.tests;

import static org.junit.Assert.assertEquals;

import cs5500.project.engine.winnow.normalise.NormalisedFile;
import java.io.IOException;
import org.junit.Test;

/**
 * @author Joyal Tests for checking whether a file has been normalised or not
 */
public class NormalisedFileTests {

  private String prjPath = "/Study/CS5500/Project/team-27/PhaseC/server/src/test/java/engine/winnow/tests/testfiles/";

  @Test
  public void testLowerCase() {
    String filePath = prjPath + "testFile2.java";
    try {
      NormalisedFile nf = new NormalisedFile(filePath);
      nf.changeToLowerCase();

      String expectedOutput = String.format(
          "package engine.winnow.tests.testfiles;\r\npublic class tolowercase {\r\n  public static void main(string[] args){\r\n    system.out.println(\"this text should be converted to lowercase\");\r\n  }\r\n}\n");

      String actualOutput = nf.getFileContents();
      assertEquals(expectedOutput, actualOutput);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testFileComments() {
    String filePath = prjPath + "testFile1.java";
    try {
      NormalisedFile nf = new NormalisedFile(filePath);
      nf.removeFileComments();

      String expectedOutput = "package engine.winnow.tests.testfiles;\n"
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
    String filePath = prjPath + "testFile2.java";
    try {
      NormalisedFile nf = new NormalisedFile(filePath);
      nf.tokenizeKeywords();
      String expectedOutput = " package engine. winnow. tests. testfiles ; \r\n"
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
    String filePath = prjPath + "testFile1.java";
    try {
      NormalisedFile nf = new NormalisedFile(filePath);
      nf.replaceIdentifiers();

      String expectedOutput = "package engine.winnow.tests.testfiles;\n"
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
    String filePath = prjPath + "testFile1.java";
    try {
      NormalisedFile nf = new NormalisedFile(filePath);
      nf.removeKeywords();
      String expectedOutput = " engine.winnow.tests.testfiles;\r\n"
          + "\r\n"
          + "/**\r\n"
          + " * @author Joyal\r\n"
          + " * File comments is a  with comments\r\n"
          + " */\r\n"
          + "  testFile1 {\r\n"
          + "  //Initializing main\r\n"
          + "     main([] args){\r\n"
          + "    // variable declaration\r\n"
          + "     i;\r\n"
          + "    //Pr Statement\r\n"
          + "    .out.prln(\"When run  test, the output should not contain any comments\");\r\n"
          + "  }\r\n"
          + "}\r\n";
      String actualOutput = nf.getFileContents();
      assertEquals(expectedOutput, actualOutput);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testRemovePunctuations() {
    String filePath = prjPath + "testFile1.java";
    try {
      NormalisedFile nf = new NormalisedFile(filePath);
      nf.removePunctuations();
      String expectedOutput = "package enginewinnowteststestfiles\r\n"
          + "\r\n"
          + "/**\r\n"
          + " * @author Joyal\r\n"
          + " * File comments is a class with comments\r\n"
          + " */\r\n"
          + "public class testFile1 \r\n"
          + "  //Initializing main\r\n"
          + "  public static void mainString args\r\n"
          + "    // variable declaration\r\n"
          + "    int i\r\n"
          + "    //Print Statement\r\n"
          + "    SystemoutprintlnWhen run for test the output should not contain any comments\r\n"
          + "  \r\n"
          + "\r\n";
      String actualOutput = nf.getFileContents();
      assertEquals(expectedOutput, actualOutput);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testGetNormalisedFile(){
    String filePath = prjPath + "testFile2.java";
    try {
      NormalisedFile nf = new NormalisedFile(filePath);

      String expectedOutput = "enginewinnowteststestfiles\n"
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