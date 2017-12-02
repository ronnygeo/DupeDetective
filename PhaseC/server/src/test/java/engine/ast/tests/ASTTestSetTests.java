package engine.ast.tests;

import cs5500.project.engine.Parser;
import cs5500.project.engine.ast.visitor.ASTStructureVisitor;
import cs5500.project.engine.ast.compare.ASTTypeCompare;
import cs5500.project.engine.ast.CustomASTParser;
import engine.TestUtils;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ASTTestSetTests {
    private Parser<CompilationUnit> astParser;
    private TestUtils utils;

    @Before
    public void setup() {
        astParser = new CustomASTParser();
        utils = new TestUtils();
    }

    @Test
    public void testCompareDifferentOrder() {
        String testCode1 = utils.readFile("sets/set01/Sample1/LinkedList.java");
        String testCode2 = utils.readFile("sets/set01/Sample2/SimpleLinkedList.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.95, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }
}
