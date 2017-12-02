package engine.ast.tests;

import cs5500.project.engine.Parser;
import cs5500.project.engine.ast.compare.ASTParentCompare;
import cs5500.project.engine.ast.visitor.ASTLoopVisitor;
import cs5500.project.engine.ast.CustomASTParser;
import engine.TestUtils;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * AST Loop Comparison tests
 */
public class ASTLoopCompareTests {

    private Parser<CompilationUnit> astParser;

    @Before
    public void setup() {
        astParser = new CustomASTParser();
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
        assertEquals(0.71, astc.getScoreParent(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList()), 0.01);

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
        TestUtils util = new TestUtils();
        String testCode1 = util.readFile("Clone1.java");
        String testCode2 = util.readFile("Clone2.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astlc = new ASTParentCompare();
        assertEquals(0.66, astlc.getScoreParent(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testSameFiles() {
        TestUtils util = new TestUtils();
        String testCode1 = util.readFile("Clone1.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode1);
        ASTVisitor visitor1 = new ASTLoopVisitor();
        ASTVisitor visitor2 = new ASTLoopVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astlc = new ASTParentCompare();
        assertEquals(1, astlc.getScoreParent(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList()), 0.01);
    }
}
