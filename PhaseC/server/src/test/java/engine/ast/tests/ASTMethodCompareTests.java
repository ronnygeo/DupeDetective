package engine.ast.tests;

import com.dupedetective.engine.Parser;
import com.dupedetective.engine.ast.visitor.ASTMethodVisitor;
import com.dupedetective.engine.ast.compare.ASTParentCompare;
import com.dupedetective.engine.ast.CustomASTParser;
import engine.TestUtils;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ASTMethodCompareTests {

    private Parser<CompilationUnit> astParser;
    private TestUtils utils;

    @Before
    public void setup() {
        astParser = new CustomASTParser();
        utils = new TestUtils();
    }

    @Test
    public void testMethodDifferentReturn() {
        String testCode1 = "\n public class A {" +
                "\npublic String parse(String txt) {return \"hello\";} \n} ";
        String testCode2 = "\n public class A {" +
                "\npublic String parse(String txt) {return \"Hello!\";} \n} ";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astmc = new ASTParentCompare();

        assertEquals(1, astmc.getScoreParent(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testMethodSame() {
        String testCode1 = "\n public class A {" +
                "\npublic String parse(String txt) {return i;} \n} ";
        String testCode2 = "\n public class A {" +
                "\npublic String parse(String txt) {return j;} \n} ";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);
        ASTParentCompare astmc = new ASTParentCompare();

        assertEquals(1, astmc.getScoreParent(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testMethodFull() {
        String testCode1 = "\n public class A {" +
                "\npublic String parse(String txt) {return \"hello\";} \n} ";
        String testCode2 = "\n public class A {" +
                "\npublic String parse(String txt) {return \"world\";} \n} ";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);
        ASTParentCompare astmc = new ASTParentCompare();

        assertEquals(1, astmc.getScoreParent(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testSameFiles() {
        String testCode1 = utils.readFile("Clone1.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode1);
        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astmc = new ASTParentCompare();
        assertEquals(1, astmc.getScoreParent(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testDiffFiles() {
        String testCode1 = utils.readFile("Clone3.java");
        String testCode2 = utils.readFile("Clone4.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astmc = new ASTParentCompare();
        assertEquals(1, astmc.getScoreParent(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testAditya(){
        String testCode1 = utils.readFile("test11O.java");
        String testCode2 = utils.readFile("test11S.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);
        ASTParentCompare astmc = new ASTParentCompare();
        assertEquals(0.7, astmc.getScoreParent(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testSameFilesCompareLCS() {
        TestUtils util = new TestUtils();
        String testCode1 = util.readFile("Clone1.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode1);
        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astlc = new ASTParentCompare();
        assertEquals(30, astlc.compare(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()).size(), 0.01);
    }

    @Test
    public void testArraysLists(){
        String testCode1 = utils.readFile("CloneArray1.java");
        String testCode2 = utils.readFile("CloneArray2.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);
        ASTParentCompare astmc = new ASTParentCompare();
        assertEquals(0.51, astmc.getScoreParent(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()), 0.05);
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

        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astc = new ASTParentCompare();
        assertEquals(0.78, astc.getScoreParent(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testFilesWithTry() {
        String testCode1 = utils.readFile("Clone6.java");
        String testCode2 = utils.readFile("Clone5.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astsc = new ASTParentCompare();
        assertEquals(0.75, astsc.getScoreParent(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testNewForLoop() {
        String testCode1 = utils.readFile("Clone1.java");
        String testCode2 = utils.readFile("Clone7.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astsc = new ASTParentCompare();
        assertEquals(0.72, astsc.getScoreParent(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()), 0.05);
    }

    @Test
    public void testClass() {
        String testCode1 = utils.readFile("TestClass1.java");
        String testCode2 = utils.readFile("TestClass2.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTParentCompare astsc = new ASTParentCompare();
        assertEquals(1, astsc.getScoreParent(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()), 0.05);
    }
}
