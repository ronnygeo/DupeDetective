package engine.ast.tests;

import cs5500.project.engine.Parser;
import cs5500.project.engine.ast.ASTHashObject;
import cs5500.project.engine.ast.ASTLoopVisitor;
import cs5500.project.engine.ast.CustomASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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

        List<List<ASTHashObject>> hashedList = ((ASTLoopVisitor) visitor).getList();

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

        List<List<ASTHashObject>> hashedList = ((ASTLoopVisitor) visitor).getList();

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

        List<List<ASTHashObject>> hashedList = ((ASTLoopVisitor) visitor).getList();

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

        List<List<ASTHashObject>> hashedList = ((ASTLoopVisitor) visitor).getList();

        assertTrue(hashedList.size() == 1);
    }

}
