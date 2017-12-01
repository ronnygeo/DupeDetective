package engine.ast.tests;

import cs5500.project.engine.Parser;
import cs5500.project.engine.ast.*;
import engine.TestUtils;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * AST structure comparison tests
 */
public class ASTStructureCompareTests {
    private Parser<CompilationUnit> astParser;

    @Before
    public void setup() {
        astParser = new CustomASTParser();
    }

    @Test
    public void testCompareDifferentOrder() {
        String testCode1 = "public class A { int j; \n int i = 9; }";
        String testCode2 = "public class B { int i = 9;  \n int j; }";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.875, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareVariableNameChanges() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "public class B { int f = 9; }";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(1, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareChangeDataType() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "public class B { float i = 9; }";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(1, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareDifferentIncr() {
        String testCode1 = "public class A { int i = 9; public void incr() {i++;} }";
        String testCode2 = "public class B { float i = 9; public void incr() { i+= 1;}}";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.76, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareDifferentDataTypes() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "\n public class A { public A() {} \n" +
                "public String parse(String txt) {int i = 9; \n }";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.375, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareInvertIfElse() {
        String testCode1 = "public class A { int i = 9;\n public String parse(String txt) { if (i > 10) System.out.println(i); else continue;} }";
        String testCode2 = "public class B { float i = 9;\n public String parse(String txt) {if (i <= 10) continue; else System.out.println(i);}}";
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
    public void testCompareLoops() {
        String testCode1 = "public class A { int i = 9;  \n int j;\n public String parse(String txt) { for(int k=1; k <10; k++) System.out.println(k);\n j=1+2; }}";
        String testCode2 = "public class B { float i = 9;  \n float j;\n public String parse(String txt) { int k=1;\n while(k <10) System.out.println(k);\n j=1+2; k++;}}";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.86, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareArrays() {
        String testCode1 = "public class A { public void doSomething() { ArrayList<Integer> al = new ArrayList<Integer>(); }}";
        String testCode2 = "public class B {  ArrayList<Integer> al; public void doSomething() { al = new ArrayList<Integer>(); }}";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astc = new ASTTypeCompare();
        assertEquals(0.53, astc.getScore(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testTwoFiles() {
        TestUtils util = new TestUtils();
        String testCode1 = util.readFile("Clone1.java");
        String testCode2 = util.readFile("Clone2.java");
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);
        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTTypeCompare astsc = new ASTTypeCompare();
        assertEquals(52, astsc.compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()).size(), 0.01);
    }
}
