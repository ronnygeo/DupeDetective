package engine.ast.tests;

import com.dupedetective.engine.Parser;
import com.dupedetective.engine.ast.CustomASTParser;
import com.dupedetective.engine.ast.compare.ASTTypeCompare;
import com.dupedetective.engine.ast.visitor.ASTStructureVisitor;
import engine.TestUtils;
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
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.899, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testCompareVariableNameChanges() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "public class B { int f = 9; }";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(1, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareChangeDataType() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "public class B { float i = 9; }";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(1, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareDifferentIncr() {
        String testCode1 = "public class A { int i = 9; public void incr() {i++;} }";
        String testCode2 = "public class B { float i = 9; public void incr() { i+= 1;}}";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.78, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareDifferentDataTypes() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "\n public class A { public A() {} \n" +
                "public String parse(String txt) {int i = 9; \n }";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.375, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareInvertIfElse() {
        String testCode1 = "public class A { int i = 9;\n public String parse(String txt) { if (i > 10) System.out.println(i); else continue;} }";
        String testCode2 = "public class B { float i = 9;\n public String parse(String txt) {if (i <= 10) continue; else System.out.println(i);}}";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.95, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareLoops() {
        String testCode1 = "public class A { int i = 9;  \n int j;\n public String parse(String txt) { for(int k=1; k <10; k++) System.out.println(k);\n j=1+2; }}";
        String testCode2 = "public class B { float i = 9;  \n float j;\n public String parse(String txt) { int k=1;\n while(k <10) System.out.println(k);\n j=1+2; k++;}}";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.87, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testCompareArrays() {
        String testCode1 = "public class A { public void doSomething() { ArrayList<Integer> al = new ArrayList<Integer>(); }}";
        String testCode2 = "public class B {  ArrayList<Integer> al; public void doSomething() { al = new ArrayList<Integer>(); }}";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.58, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
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

        ASTTypeCompare astsc = new ASTTypeCompare();
        assertEquals(52, astsc.compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()).size(), 0.01);
    }

    @Test
    public void testSameFiles() {
        String testCode1 = utils.readFile("Clone1.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode1);
        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astsc = new ASTTypeCompare();
        assertEquals(1, astsc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testDiffFiles() {
        String testCode1 = utils.readFile("Clone3.java");
        String testCode2 = utils.readFile("Clone4.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astsc = new ASTTypeCompare();
        assertEquals(0.77, astsc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testFilesWithTry() {
        String testCode1 = utils.readFile("Clone6.java");
        String testCode2 = utils.readFile("Clone5.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astsc = new ASTTypeCompare();
        assertEquals(0.83, astsc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testAditya(){
        String testCode1 = utils.readFile("test11O.java");
        String testCode2 = utils.readFile("test11S.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);
        ASTTypeCompare astmc = new ASTTypeCompare();
        assertEquals(0.86, astmc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testArraysLists(){
        String testCode1 = utils.readFile("CloneArray1.java");
        String testCode2 = utils.readFile("CloneArray2.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);
        ASTTypeCompare astmc = new ASTTypeCompare();
        assertEquals(0.59, astmc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.05);
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
        assertEquals(73, astlc.compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()).size(), 0.01);
    }

    @Test
    public void testSameForWhile() {
        String testCode1 = "\n public class A {" +
                "\npublic String parse(String txt) { \n " +
                "for(int i=0; i<7;i++) {i = j; new System(); }} \n} ";
        String testCode2 = "\n public class A {" +
                "\npublic String parse(String txt) { \n " +
                "int i=0; while(i<7) {i = j; new System(); i++;}} \n} ";

        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.81, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testNewLoop(){
        String testCode1 = utils.readFile("Clone1.java");
        String testCode2 = utils.readFile("Clone7.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);
        ASTTypeCompare astmc = new ASTTypeCompare();
        assertEquals(0.75, astmc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.05);
    }


    @Test
    public void testClass(){
        String testCode1 = utils.readFile("TestClass1.java");
        String testCode2 = utils.readFile("TestClass2.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);
        ASTTypeCompare astmc = new ASTTypeCompare();
        assertEquals(0.75, astmc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.05);
    }
}
