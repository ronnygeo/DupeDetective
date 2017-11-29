package engine.ast.tests;

import cs5500.project.engine.Parser;
import cs5500.project.engine.ast.ASTHashObject;
import cs5500.project.engine.ast.ASTLoopVisitor;
import cs5500.project.engine.ast.CustomASTParser;
import engine.TestUtils;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Testing AST Loop Visitor
 */
public class ASTLoopVisitorTests {

    private Parser<CompilationUnit> astParser;

    @Before
    public void setup() {
        astParser = new CustomASTParser();
    }

    @Test
    public void testNoLoop() {
        String testCode = "public class A {" +
                "\n public void doSomething(){i = j; new System(); }} ";

        CompilationUnit cu = astParser.parse(testCode);

        ASTVisitor visitor = new ASTLoopVisitor();
        cu.accept(visitor);

        List<ASTHashObject> hashedList = ((ASTLoopVisitor) visitor).getList();

        assertTrue(hashedList.size() == 0);
    }

    @Test
    public void testOneLoop() {
        String testCode = "\n public class A {" +
                "\npublic String parse(String txt) { \n " +
                "for(int i=0; i<7;i++) {i = j; new System(); }} \n} ";
        CompilationUnit cu = astParser.parse(testCode);

        ASTVisitor visitor = new ASTLoopVisitor();
        cu.accept(visitor);

        List<ASTHashObject> hashedList = ((ASTLoopVisitor) visitor).getList();

        assertTrue(hashedList.size() == 1);
    }


    @Test
    public void testOneCond() {
        String testCode = "\n public class A {" +
                "@Override\npublic String parse(String txt) { \n " +
                "if (i>10) j = 0; else j=1;} \n} ";
        CompilationUnit cu = astParser.parse(testCode);

        ASTVisitor visitor = new ASTLoopVisitor();
        cu.accept(visitor);

        List<ASTHashObject> hashedList = ((ASTLoopVisitor) visitor).getList();

        assertTrue(hashedList.size() == 1);
    }

    @Test
    public void testOneSwitch() {
        String testCode = "\n public class A {" +
                "@Override\npublic String parse(String txt) { \n " +
                "switch(i) {case 10: j = 0; break; default: j=1; break;}} \n} ";
        CompilationUnit cu = astParser.parse(testCode);

        ASTVisitor visitor = new ASTLoopVisitor();
        cu.accept(visitor);

        List<ASTHashObject> hashedList = ((ASTLoopVisitor) visitor).getList();

        assertTrue(hashedList.size() == 1);
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

        assertEquals(((ASTLoopVisitor) visitor1).getList().size(), ((ASTLoopVisitor) visitor2).getList().size());
    }
}
