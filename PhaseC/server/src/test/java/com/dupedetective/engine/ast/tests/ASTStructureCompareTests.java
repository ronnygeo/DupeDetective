package com.dupedetective.engine.ast.tests;

import com.dupedetective.engine.Parser;
import com.dupedetective.engine.TestUtils;
import com.dupedetective.engine.ast.CustomASTParser;
import com.dupedetective.engine.ast.compare.ASTTypeCompare;
import com.dupedetective.engine.ast.visitor.ASTStructureVisitor;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * AST structure comparison tests
 */
public class ASTStructureCompareTests {
    private Parser<CompilationUnit> astParser;
    private TestUtils utils;


    @Before
    public void setup() {
        astParser = new CustomASTParser();
        utils = new TestUtils();
    }

    @Test
    public void testCompareDifferentOrder() {
        String testCode1 = "public class A { int j; \n int i = 9; }";
        String testCode2 = "public class B { int i = 9;  \n int j; }";
        assertEquals(0.899, getScore(testCode1, testCode2), 0.05);
    }

    @Test
    public void testCompareVariableNameChanges() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "public class B { int f = 9; }";
        assertEquals(1, getScore(testCode1, testCode2), 0.01);
    }

    @Test
    public void testCompareChangeDataType() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "public class B { float i = 9; }";
        assertEquals(1, getScore(testCode1, testCode2), 0.01);
    }

    @Test
    public void testCompareDifferentIncr() {
        String testCode1 = "public class A { int i = 9; public void incr() {i++;} }";
        String testCode2 = "public class B { float i = 9; public void incr() { i+= 1;}}";
        assertEquals(0.78, getScore(testCode1, testCode2), 0.01);
    }

    @Test
    public void testCompareDifferentDataTypes() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "\n public class A { public A() {} \n" +
                "public String parse(String txt) {int i = 9; \n }";
        assertEquals(0.375, getScore(testCode1, testCode2), 0.01);
    }

    @Test
    public void testCompareInvertIfElse() {
        String testCode1 = "public class A { int i = 9;\n public String parse(String txt) { if (i > 10) System.out.println(i); else continue;} }";
        String testCode2 = "public class B { float i = 9;\n public String parse(String txt) {if (i <= 10) continue; else System.out.println(i);}}";
        assertEquals(0.95,  getScore(testCode1, testCode2), 0.01);
    }

    @Test
    public void testCompareLoops() {
        String testCode1 = "public class A { int i = 9;  \n int j;\n public String parse(String txt) { for(int k=1; k <10; k++) System.out.println(k);\n j=1+2; }}";
        String testCode2 = "public class B { float i = 9;  \n float j;\n public String parse(String txt) { int k=1;\n while(k <10) System.out.println(k);\n j=1+2; k++;}}";
        assertEquals(0.87, getScore(testCode1, testCode2), 0.05);
    }

    @Test
    public void testCompareArrays() {
        String testCode1 = "public class A { public void doSomething() { ArrayList<Integer> al = new ArrayList<Integer>(); }}";
        String testCode2 = "public class B {  ArrayList<Integer> al; public void doSomething() { al = new ArrayList<Integer>(); }}";
        assertEquals(0.58,  getScore(testCode1, testCode2), 0.01);
    }

    @Test
    public void testTwoFiles() {
        String testCode1 = utils.readFile("Clone1.java");
        String testCode2 = utils.readFile("Clone2.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astlc = new ASTTypeCompare();
        assertEquals(43, astlc.compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()).size(), 0.01);
    }

    @Test
    public void testSameFiles() {
        String testCode1 = utils.readFile("Clone1.java");
        assertEquals(1, getScore(testCode1, testCode1), 0.01);
    }

    @Test
    public void testDiffFiles() {
        String testCode1 = utils.readFile("Clone3.java");
        String testCode2 = utils.readFile("Clone4.java");
        assertEquals(0.77,  getScore(testCode1, testCode2), 0.05);
    }

    @Test
    public void testFilesWithTry() {
        String testCode1 = utils.readFile("Clone6.java");
        String testCode2 = utils.readFile("Clone5.java");
        assertEquals(0.83,  getScore(testCode1, testCode2), 0.05);
    }

    @Test
    public void testAditya(){
        String testCode1 = utils.readFile("test11O.java");
        String testCode2 = utils.readFile("test11S.java");
        assertEquals(0.86,  getScore(testCode1, testCode2), 0.05);
    }

    @Test
    public void testArraysLists(){
        String testCode1 = utils.readFile("CloneArray1.java");
        String testCode2 = utils.readFile("CloneArray2.java");
        assertEquals(0.59,  getScore(testCode1, testCode2), 0.05);
    }

    @Test
    public void testSameFilesCompareLCS() {
        TestUtils util = new TestUtils();
        String testCode1 = util.readFile("Clone1.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode1);
        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astlc = new ASTTypeCompare();
        assertEquals(63, astlc.compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()).size(), 0.01);
    }

    @Test
    public void testSameForWhile() {
        String testCode1 = "\n public class A {" +
                "\npublic String parse(String txt) { \n " +
                "for(int i=0; i<7;i++) {i = j; new System(); }} \n} ";
        String testCode2 = "\n public class A {" +
                "\npublic String parse(String txt) { \n " +
                "int i=0; while(i<7) {i = j; new System(); i++;}} \n} ";
        assertEquals(0.81, getScore(testCode1, testCode2), 0.01);
    }

    @Test
    public void testNewLoop(){
        String testCode1 = utils.readFile("Clone1.java");
        String testCode2 = utils.readFile("Clone7.java");
        assertEquals(0.75, getScore(testCode1, testCode2), 0.05);
    }


    @Test
    public void testClass(){
        String testCode1 = utils.readFile("TestClass1.java");
        String testCode2 = utils.readFile("TestClass2.java");
        assertEquals(0.75, getScore(testCode1,testCode2), 0.05);
    }

    @Test
    public void testTernary() {
        String testCode1 = "public class A {\n" +
                "  public static int findLargerOneWithIf(int a, int b) { \n" +
                "    if (a > b) {\n" +
                "      return a;\n" +
                "    } else {\n" +
                "      return b;\n" +
                "    }\n" +
                "  }\n" +
                "}";
        String testCode2 = "public class B {\n" +
                "   public static int findLargerOneWithoutIf(int a, int b) { \n" +
                "    return a > b ? a : b;\n" +
                "  }\n" +
                "}";
        assertEquals(0.625, getScore(testCode1,testCode2), 0.05);
    }

    @Test
    public void testJuukeiTest() {
        String testCode1 = "  public class A {\n" +
                "    public static void forLoopWithIf(int[] arr) { \n" +
                "      for(int i = 0; i < arr.length; i++) {\n" +
                "        if (arr[i] % 2 != 0) {\n" +
                "          System.out.println(arr[i]);\n" +
                "        } else {\n" +
                "          System.out.println(\"Even\");\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }";
        String testCode2 = "  public class B {\n" +
                "    public static void forLoopWithSwitch(int[] arr) { \n" +
                "      for(int i = 0; i < arr.length; i++) {\n" +
                "        switch(arr[i] % 2) {\n" +
                "          case 1:\n" +
                "            System.out.println(arr[i]);\n" +
                "            break;\n" +
                "          default:\n" +
                "            System.out.println(\"Even\");\n" +
                "            break;\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }";
        assertEquals(0.86, getScore(testCode1, testCode2), 0.05);
    }

    /**
     * @param testCode1 first code to test
     * @param testCode2 second code to test
     * @return similarity score
     */
    private float getScore(String testCode1, String testCode2) {
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astsc = new ASTTypeCompare();
        return astsc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList());
    }
}
