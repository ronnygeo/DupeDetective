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
        assertEquals(0.95, getScore("sets/set01/Sample1/LinkedList.java",
                "sets/set01/Sample2/SimpleLinkedList.java"), 0.05);
    }

    @Test
    public void testSet02a() {
        assertEquals(0.75, getScore("sets/set02/Sample1/LinkedList.java",
                "sets/set02/Sample2/LinkedList.java"), 0.05);
    }

    @Test
    public void testSet02b() {
        assertEquals(0.14, getScore("sets/set02/Sample1/LinkedList.java",
                "sets/set02/Sample2/ListIterator.java"), 0.05);
            }

    @Test
    public void testSet02c() {
        assertEquals(0.09, getScore("sets/set02/Sample1/LinkedList.java",
                "sets/set02/Sample2/Node.java"), 0.05);
    }

    @Test
    public void testSet03a() {
        assertEquals(0.28, getScore("sets/set03/Sample1/DLLNode.java",
                "sets/set03/Sample2/Node.java"), 0.05);
    }

    @Test
    public void testSet03b() {
        assertEquals(0.65, getScore("sets/set03/Sample1/DLL.java",
                "sets/set03/Sample2/LinkedList.java"), 0.05);
    }

    @Test
    public void testSet04a() {
        assertEquals(0.99, getScore("sets/set04/Sample1/DLL.java",
                                    "sets/set04/Sample2/LinkedList.java"), 0.05);
    }

    @Test
    public void testSet04b() {
        assertEquals(0.96, getScore("sets/set04/Sample1/DLLNode.java",
                "sets/set04/Sample2/Node.java"), 0.05);
    }

    @Test
    public void testSet05a() {
        assertEquals(0.70, getScore("sets/set05/Sample1/DLLNode.java",
                                             "sets/set05/Sample2/Node.java"), 0.05);
    }

    @Test
    public void testSet05b() {
        assertEquals(0.47, getScore("sets/set05/Sample1/DLL.java",
                "sets/set05/Sample2/LinkedList.java"), 0.05);
    }

    @Test
    public void testSet06a() {
        assertEquals(1, getScore("sets/set06/Sample1/src/MyIntToBin.java",
                "sets/set06/Sample2/src/IntToBinCopy.java"), 0.05);
    }

    @Test
    public void testSet06b() {
        assertEquals(1, getScore("sets/set06/Sample1/src/SolutionB.java",
                "sets/set06/Sample2/src/SolutionA.java"), 0.05);
    }

    @Test
    public void testSet07a() {
        assertEquals(0.17, getScore("sets/set07/Sample1/src/IntegerConverter.java",
                "sets/set07/Sample2/src/CallConvertor.java"), 0.05);
    }

    @Test
    public void testSet07b() {
        assertEquals(0.53, getScore("sets/set07/Sample1/src/IntegerConverter.java",
                "sets/set07/Sample2/src/ConverterX.java"), 0.05);
    }

    @Test
    public void testSet07c() {
        assertEquals(0.34, getScore("sets/set07/Sample1/src/IntegerConverter.java",
                "sets/set07/Sample2/src/NumberStringConstants.java"), 0.05);
    }

    @Test
    public void testSet08() {
        assertEquals(0.65, getScore("sets/set08/Sample1/src/SolutionA.java",
                "sets/set08/Sample2/src/SolutionB.java"), 0.05);
    }

    @Test
    public void testSet09() {
        assertEquals(0.45, getScore("sets/set09/Sample1/src/Tokenize.java",
                "sets/set09/Sample2/src/Words.java"), 0.05);
    }

    @Test
    public void testSet11a() {
        assertEquals(1, getScore("sets/set11/Sample1/Checker.java",
                "sets/set11/Sample2/Checker.java"), 0.05);
    }

    @Test
    public void testSet11b() {
        assertEquals(1, getScore("sets/set11/Sample1/Player.java",
                "sets/set11/Sample2/Player.java"), 0.05);
    }

    @Test
    public void testSet11c() {
        assertEquals(0.89, getScore("sets/set11/Sample1/Solution.java",
                "sets/set11/Sample2/Solution.java"), 0.05);
    }

    @Test
    public void testSet12() {
        assertEquals(0.89, getScore("sets/set12/Sample1/Solution",
                "sets/set12/Sample2/Solution"), 0.05);
    }

    @Test
    public void testSet13a() {
        assertEquals(0.95, getScore("sets/set13/Sample1/Solution",
                "sets/set13/Sample2/Solution"), 0.05);
    }

    @Test
    public void testSet13b() {
        assertEquals(1, getScore("sets/set13/Sample1/ValueComparator",
                "sets/set13/Sample2/ValueComparator"), 0.05);
    }

    @Test
    public void testSet14a() {
        assertEquals(0.89, getScore("sets/set14/Sample1/Node",
                "sets/set14/Sample2/Node"), 0.05);
    }

    @Test
    public void testSet14b() {
        assertEquals(0.81, getScore("sets/set14/Sample1/Solution",
                "sets/set14/Sample2/Solution"), 0.05);
    }

    @Test
    public void testSet15() {
        assertEquals(0.89, getScore("sets/set15/Sample1/Solution",
                "sets/set15/Sample2/Solution"), 0.05);
    }

    @Test
    public void testSet16a() {
        assertEquals(1, getScore("sets/set16/Sample1/CustomerDao.java",
                "sets/set16/Sample2/PersonDao.java"), 0.05);
    }

    @Test
    public void testSet16b() {
        assertEquals(1, getScore("sets/set16/Sample1/Customer.java",
                "sets/set16/Sample2/Person.java"), 0.05);
    }

    @Test
    public void testSet16c() {
        assertEquals(0.95, getScore("sets/set16/Sample1/DbCustomerDao.java",
                "sets/set16/Sample2/DatabasePerson.java"), 0.05);
    }

    @Test
    public void testSet17() {
        assertEquals(1, getScore("sets/set17/Sample1/ValidateTree.java",
                "sets/set17/Sample2/ValidateTree.java"), 0.05);
    }

    @Test
    public void testSet18() {
        assertEquals(0.94, getScore("sets/set18/Sample1/SearchArray.java",
                "sets/set18/Sample2/SearchArray.java"), 0.05);
    }

    @Test
    public void testSet19() {
        assertEquals(0.89, getScore("sets/set19/Sample1/Solution.java",
                "sets/set19/Sample2/Solution.java"), 0.05);
    }

    @Test
    public void testSet20() {
        assertEquals(0.79, getScore("sets/set20/Sample1/Solution.java",
                "sets/set20/Sample2/Solution.java"), 0.05);
    }


    private Float getScore(String filepath1, String filepath2) {
        String testCode1 = utils.readFile(filepath1);
        String testCode2 = utils.readFile(filepath2);
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        return astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList());
    }
}
