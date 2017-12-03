package engine.ast.tests;

import com.dupedetective.engine.Parser;
import com.dupedetective.engine.ast.ASTHashObject;
import com.dupedetective.engine.ast.compare.ASTParentCompare;
import com.dupedetective.engine.ast.visitor.ASTLoopVisitor;
import com.dupedetective.engine.ast.CustomASTParser;
import engine.TestUtils;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * AST Loop Comparison tests
 */
public class ASTLoopCompareTests {

    private Parser<CompilationUnit> astParser;
    private TestUtils utils;


    @Before
    public void setup() {
        astParser = new CustomASTParser();
        utils = new TestUtils();
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

        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astc = new ASTParentCompare();
        assertEquals(0.75, astc.getScoreParent(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList()), 0.01);

    }

    @Test
    public void testForForIn() {
        String testCode1 = "\n public class A {" +
                "\npublic void forLoop(int[] arr) { \n " +
                "for(int j = 0; j < arr.length; j++) {i = arr[j];}} \n} ";
        String testCode2 = "\n public class A {" +
                "\npublic void forLoop(int[] arr) { \n " +
                "for(int num : arr) {i = num;}} \n} ";

        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astc = new ASTParentCompare();
        assertEquals(0.4, astc.getScoreParent(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testIfSwitch() {
        String testCode1 = "\n public class A {" +
                "@Override\npublic String parse(String txt) {int i = 9;  \n int j; \n " +
                "if (i == 10) j = 0; else j=1;} \n} ";
        String testCode2 = "\n public class A {" +
                "@Override\npublic String parse(String txt) {int i = 9;  \n int j; \n " +
                "switch(i) {case 10: j = 0; break; default: j=1; break;}} \n} ";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        assertNotEquals(((ASTLoopVisitor) visitor1).getList().get(0), ((ASTLoopVisitor) visitor2).getList().get(0));
    }

    @Test
    public void testTwoFiles() {
        String testCode1 = utils.readFile("Clone1.java");
        String testCode2 = utils.readFile("Clone2.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astlc = new ASTParentCompare();
        assertEquals(0.57, astlc.getScoreParent(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testSameFiles() {
        String testCode1 = utils.readFile("Clone1.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode1);
        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astlc = new ASTParentCompare();
        assertEquals(1, astlc.getScoreParent(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testSameFilesCompareLCS() {
        String testCode1 = utils.readFile("Clone1.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode1);
        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astlc = new ASTParentCompare();
        assertEquals(6, astlc.compare(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList()).size(), 0.01);
    }

    @Test
    public void testDiffFiles() {
        String testCode1 = utils.readFile("Clone3.java");
        String testCode2 = utils.readFile("Clone4.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astmc = new ASTParentCompare();
        assertEquals(0, astmc.getScoreParent(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testAditya(){
        String testCode1 = utils.readFile("test11O.java");
        String testCode2 = utils.readFile("test11S.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);
        ASTParentCompare astmc = new ASTParentCompare();
        assertEquals(1, astmc.getScoreParent(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testArraysLists(){
        String testCode1 = utils.readFile("CloneArray1.java");
        String testCode2 = utils.readFile("CloneArray2.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);
        ASTParentCompare astmc = new ASTParentCompare();
        System.out.println(((ASTLoopVisitor) visitor1).getList().get(0).getNodes().stream().map(ASTHashObject::getType).collect(Collectors.toList()));
        System.out.println(((ASTLoopVisitor) visitor2).getList().get(0).getNodes().stream().map(ASTHashObject::getType).collect(Collectors.toList()));
        assertEquals(0.42, astmc.getScoreParent(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testFilesWithTry() {
        String testCode1 = utils.readFile("Clone6.java");
        String testCode2 = utils.readFile("Clone5.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astsc = new ASTParentCompare();
        System.out.println(((ASTLoopVisitor) visitor1).getList().size());
        System.out.println(((ASTLoopVisitor) visitor2).getList().size());
        assertEquals(0.74, astsc.getScoreParent(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testFilesNewLoop() {
        String testCode1 = utils.readFile("Clone1.java");
        String testCode2 = utils.readFile("Clone7.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astsc = new ASTParentCompare();
        System.out.println(((ASTLoopVisitor) visitor1).getList().size());
        System.out.println(((ASTLoopVisitor) visitor2).getList().size());
        assertEquals(0.33, astsc.getScoreParent(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList()), 0.05);
    }


    @Test
    public void testClass() {
        String testCode1 = utils.readFile("TestClass1.java");
        String testCode2 = utils.readFile("TestClass2.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astsc = new ASTParentCompare();
        System.out.println(((ASTLoopVisitor) visitor1).getList().size());
        System.out.println(((ASTLoopVisitor) visitor2).getList().size());
        assertEquals(0.33, astsc.getScoreParent(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList()), 0.05);
    }
}
