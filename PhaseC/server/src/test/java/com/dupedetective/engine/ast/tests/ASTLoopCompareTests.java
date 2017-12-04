package com.dupedetective.engine.ast.tests;

import com.dupedetective.engine.Parser;
import com.dupedetective.engine.ast.ASTHashObject;
import com.dupedetective.engine.ast.compare.ASTParentCompare;
import com.dupedetective.engine.ast.visitor.ASTLoopVisitor;
import com.dupedetective.engine.ast.CustomASTParser;
import com.dupedetective.engine.TestUtils;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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
    public void testEmptyString() {
        String testCode = "";
        CompilationUnit cu = astParser.parse(testCode);

        ASTVisitor visitor = new ASTLoopVisitor();
        cu.accept(visitor);

        List<ASTHashObject> hashedList = ((ASTLoopVisitor) visitor).getList();

        assertTrue(hashedList.size() == 0);
    }

    @Test
    public void testNullInput() {
        String testCode = null;
        CompilationUnit cu = astParser.parse(testCode);

        ASTVisitor visitor = new ASTLoopVisitor();
        cu.accept(visitor);

        List<ASTHashObject> hashedList = ((ASTLoopVisitor) visitor).getList();

        assertTrue(hashedList.size() == 0);
    }

    @Test
    public void testSameForWhile() {
        String testCode1 = "\n public class A {" +
                "\npublic String parse(String txt) { \n " +
                "for(int i=0; i<7;i++) {i = j; new System(); }} \n} ";
        String testCode2 = "\n public class A {" +
                "\npublic String parse(String txt) { \n " +
                "int i=0; while(i<7) {i = j; new System(); i++;}} \n} ";

        assertEquals(0.75, getScore(testCode1, testCode2), 0.01);

    }
    
    @Test
    public void testForForIn() {
        String testCode1 = "\n public class A {" +
                "\npublic void forLoop(int[] arr) { \n " +
                "for(int j = 0; j < arr.length; j++) {i = arr[j];}} \n} ";
        String testCode2 = "\n public class A {" +
                "\npublic void forLoop(int[] arr) { \n " +
                "for(int num : arr) {i = num;}} \n} ";
        assertEquals(0.4, getScore(testCode1, testCode2), 0.05);
    }

    @Test
    public void testTwoFiles() {
        String testCode1 = utils.readFile("Clone1.java");
        String testCode2 = utils.readFile("Clone2.java");
        assertEquals(0.57, getScore(testCode1, testCode2), 0.01);
    }

    @Test
    public void testSameFiles() {
        String testCode1 = utils.readFile("Clone1.java");
        assertEquals(1, getScore(testCode1, testCode1), 0.01);
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
        assertEquals(0, getScore(testCode1, testCode2), 0.05);
    }

    @Test
    public void testAditya(){
        String testCode1 = utils.readFile("test11O.java");
        String testCode2 = utils.readFile("test11S.java");
        assertEquals(1, getScore(testCode1, testCode2), 0.05);
    }

    @Test
    public void testArraysLists(){
        String testCode1 = utils.readFile("CloneArray1.java");
        String testCode2 = utils.readFile("CloneArray2.java");
        assertEquals(0.42, getScore(testCode1, testCode2), 0.05);
    }

    @Test
    public void testFilesWithTry() {
        String testCode1 = utils.readFile("Clone6.java");
        String testCode2 = utils.readFile("Clone5.java");

        assertEquals(0.74, getScore(testCode1, testCode2), 0.05);
    }

    @Test
    public void testFilesNewLoop() {
        String testCode1 = utils.readFile("Clone1.java");
        String testCode2 = utils.readFile("Clone7.java");
        assertEquals(0.33, getScore(testCode1, testCode2), 0.05);
    }


    @Test
    public void testClass() {
        String testCode1 = utils.readFile("TestClass1.java");
        String testCode2 = utils.readFile("TestClass2.java");
        assertEquals(0.33, getScore(testCode1, testCode2), 0.05);
    }

    /**
     * @param testCode1 first code to test
     * @param testCode2 second code to test
     * @return similarity score
     */
    private float getScore(String testCode1, String testCode2) {
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astc = new ASTParentCompare();
        return astc.getScoreParent(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList());
    }
}
