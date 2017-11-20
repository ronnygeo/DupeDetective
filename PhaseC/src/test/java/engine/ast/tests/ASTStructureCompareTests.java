package engine.ast.tests;

import cs5500.project.engine.Parser;
import cs5500.project.engine.ast.ASTLoopVisitor;
import cs5500.project.engine.ast.ASTStructureCompare;
import cs5500.project.engine.ast.ASTStructureVisitor;
import cs5500.project.engine.ast.CustomASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
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

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTStructureCompare astc = new ASTStructureCompare();
        assertEquals(0.875, astc.compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareVariableNameChanges() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "public class B { int f = 9; }";
        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTStructureCompare astc = new ASTStructureCompare();
        assertEquals(1, astc.compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareChangeDataType() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "public class B { float i = 9; }";
        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTStructureCompare astc = new ASTStructureCompare();
        assertEquals(1, astc.compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareDifferentIncr() {
        String testCode1 = "public class A { int i = 9; public void incr() {i++;} }";
        String testCode2 = "public class B { float i = 9; public void incr() { i+= 1;}}";
        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTStructureCompare astc = new ASTStructureCompare();
        assertEquals(0.76, astc.compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareDifferentDataTypes() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "\n public class A { public A() {} \n" +
                "public String parse(String txt) {int i = 9; \n }";
        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTStructureCompare astc = new ASTStructureCompare();
        assertEquals(0.375, astc.compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareInvertIfElse() {
        String testCode1 = "public class A { int i = 9;\n public String parse(String txt) { if (i > 10) System.out.println(i); else continue;} }";
        String testCode2 = "public class B { float i = 9;\n public String parse(String txt) {if (i <= 10) continue; else System.out.println(i);}}";
        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTStructureCompare astc = new ASTStructureCompare();
        assertEquals(0.95, astc.compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareLoops() {
        String testCode1 = "public class A { int i = 9;  \n int j;\n public String parse(String txt) { for(int k=1; k <10; k++) System.out.println(k);\n j=1+2; }}";
        String testCode2 = "public class B { float i = 9;  \n float j;\n public String parse(String txt) { int k=1;\n while(k <10) System.out.println(k);\n j=1+2; k++;}}";
        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTStructureCompare astc = new ASTStructureCompare();
        assertEquals(0.86, astc.compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    @Test
    public void testCompareArrays() {
        String testCode1 = "public class A { public void doSomething() { ArrayList<Integer> al = new ArrayList<Integer>(); }}";
        String testCode2 = "public class B {  ArrayList<Integer> al; public void doSomething() { al = new ArrayList<Integer>(); }}";
        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        ASTStructureCompare astc = new ASTStructureCompare();
        assertEquals(0.53, astc.compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList()), 0.01);
    }

    //TODO: Add tests for different modifiers private/public
}
