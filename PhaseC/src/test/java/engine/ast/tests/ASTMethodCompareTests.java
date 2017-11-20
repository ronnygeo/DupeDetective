package engine.ast.tests;

import cs5500.project.engine.Parser;
import cs5500.project.engine.ast.ASTMethodCompare;
import cs5500.project.engine.ast.ASTMethodVisitor;
import cs5500.project.engine.ast.CustomASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ASTMethodCompareTests {

    private Parser<CompilationUnit> astParser;

    @Before
    public void setup() {
        astParser = new CustomASTParser();
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

        ASTMethodCompare astmc = new ASTMethodCompare();

        assertEquals(3, astmc.compare(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()).size());
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
        ASTMethodCompare astmc = new ASTMethodCompare();

        assertEquals(3, astmc.compare(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()).size());
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
        ASTMethodCompare astmc = new ASTMethodCompare();

        assertEquals(3, astmc.compare(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList()).size());
    }
}
