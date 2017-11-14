package engine.ast.tests;

import cs5500.project.engine.Parser;
import cs5500.project.engine.ast.ASTOverallCompare;
import cs5500.project.engine.ast.ASTStructureCompare;
import cs5500.project.engine.ast.ASTStructureVisitor;
import cs5500.project.engine.ast.CustomASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ASTStructureCompareTests {
    @Test
    public void testCompareDifferentOrder() {
        String testCode1 = "public class A { int j; \n int i = 9; }";
        String testCode2 = "public class B { int i = 9;  \n int j; }";
        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTStructureCompare astc = new ASTStructureCompare();
        assertEquals(0.5, astc.compare(cu1, cu2), 0.01);
    }

    @Test
    public void testCompareVariableNameChanges() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "public class B { int f = 9; }";
        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTStructureCompare astc = new ASTStructureCompare();
        assertEquals(0.5, astc.compare(cu1, cu2), 0.01);
    }

    @Test
    public void testCompareDifferentDataTypes() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "\n public class A { int i = 9; public A() {} \n" +
                "public String parse(String txt) {int i = 9;  \n int j; \n }";
        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTStructureCompare astc = new ASTStructureCompare();
        assertEquals(0.23, astc.compare(cu1, cu2), 0.01);
    }

    @Test
    public void testCompareInvertIfElse() {
        String testCode1 = "public class A { int i = 9;\n public String parse(String txt) { if (i > 10) System.out.println(i); else continue;} }";
        String testCode2 = "public class B { float i = 9;\n public String parse(String txt) {if (i <= 10) continue; else System.out.println(i);}}";
        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTStructureCompare astc = new ASTStructureCompare();
        assertEquals(0.5, astc.compare(cu1, cu2), 0.01);
    }

    @Test
    public void testCompareLoops() {
        String testCode1 = "public class A { int i = 9;  \n int j;\n for(int k=1; k <10; k++) print k;\n j=1+2; \n ArrayList<Integer> al = new ArrayList<Integer>();j=1000; }";
        String testCode2 = "public class B { float i = 9;  \n float j;\n for(int k=1; k <10; k++) print k; \n j=1+2; \n ArrayList<Float> al = new ArrayList<Float>();j=1000; }";
        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTStructureCompare astc = new ASTStructureCompare();
        assertEquals(0.5, astc.compare(cu1, cu2), 0.01);
    }
}
