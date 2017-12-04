package engine.ast.tests;

import com.dupedetective.engine.Parser;
import com.dupedetective.engine.ast.visitor.ASTStructureVisitor;
import com.dupedetective.engine.ast.compare.ASTTypeCompare;
import com.dupedetective.engine.ast.CustomASTParser;
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
    public void testSet01() {
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

    @Test
    public void testSet02() {
        String testCode1 = utils.readFile("sets/set02/Sample1/LinkedList.java");
        String testCode2 = utils.readFile("sets/set02/Sample2/LinkedList.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.75, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testSet03() {
        String testCode1 = utils.readFile("sets/set03/Sample1/DLLNode.java");
        String testCode2 = utils.readFile("sets/set03/Sample2/Node.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.28, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.05);
    }
}
