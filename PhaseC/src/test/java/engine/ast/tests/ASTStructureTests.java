package engine.ast.tests;

import cs5500.project.engine.Parser;
import cs5500.project.engine.ast.ASTOverallCompare;
import cs5500.project.engine.ast.ASTStructureVisitor;
import cs5500.project.engine.ast.CustomASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Test;

public class ASTStructureTests {
    @Test
    public void testCompareSame() {
        String testCode = "public class A { int i = 9;  \n int j;\n j=1+2; \n ArrayList<Integer> al = new ArrayList<Integer>();j=1000; }";
        Parser<CompilationUnit> astParser1 = new CustomASTParser();
        CompilationUnit parsedData1 = astParser1.parse(testCode);
        Parser<CompilationUnit> astParser2 = new CustomASTParser();
        CompilationUnit parsedData2 = astParser2.parse(testCode);
        ASTOverallCompare.compare(parsedData1, parsedData2);
    }

    @Test
    public void testCompareDifferentOrder() {
        String testCode1 = "public class A { int j; \n int i = 9; }";
        String testCode2 = "public class B { int i = 9;  \n int j; }";
        Parser<CompilationUnit> astParser1 = new CustomASTParser();
        CompilationUnit parsedData1 = astParser1.parse(testCode1);
        Parser<CompilationUnit> astParser2 = new CustomASTParser();
        CompilationUnit parsedData2 = astParser2.parse(testCode2);
        ASTOverallCompare.compare(parsedData1, parsedData2);
    }

    @Test
    public void testCompareVariableNameChanges() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "public class B { int f = 9; }";
        Parser<CompilationUnit> astParser1 = new CustomASTParser();
        CompilationUnit parsedData1 = astParser1.parse(testCode1);
        Parser<CompilationUnit> astParser2 = new CustomASTParser();
        CompilationUnit parsedData2 = astParser2.parse(testCode2);
        ASTOverallCompare.compare(parsedData1, parsedData2);
    }

    @Test
    public void testCompareDifferentDataTypes() {
        String testCode1 = "public class A { int i = 9; }";
        String testCode2 = "public class B { float i = 9; }";
        Parser<CompilationUnit> astParser1 = new CustomASTParser();
        CompilationUnit parsedData1 = astParser1.parse(testCode1);
        Parser<CompilationUnit> astParser2 = new CustomASTParser();
        CompilationUnit parsedData2 = astParser2.parse(testCode2);
        ASTOverallCompare.compare(parsedData1, parsedData2);
    }

    @Test
    public void testCompareInvertIfElse() {
        String testCode1 = "public class A { int i = 9;\n if (i > 10) System.out.println(i); else continue; }";
        String testCode2 = "public class B { float i = 9;\n if (i <= 10) continue; else System.out.println(i);}";
        Parser<CompilationUnit> astParser1 = new CustomASTParser();
        CompilationUnit parsedData1 = astParser1.parse(testCode1);
        Parser<CompilationUnit> astParser2 = new CustomASTParser();
        CompilationUnit parsedData2 = astParser2.parse(testCode2);
        ASTOverallCompare.compare(parsedData1, parsedData2);
    }

    @Test
    public void testCompareLoops() {
        String testCode1 = "public class A { int i = 9;  \n int j;\n for(int k=1; k <10; k++) print k;\n j=1+2; \n ArrayList<Integer> al = new ArrayList<Integer>();j=1000; }";
        String testCode2 = "public class B { float i = 9;  \n float j;\n for(int k=1; k <10; k++) print k; \n j=1+2; \n ArrayList<Float> al = new ArrayList<Float>();j=1000; }";
        Parser<CompilationUnit> astParser1 = new CustomASTParser();
        CompilationUnit parsedData1 = astParser1.parse(testCode1);
        Parser<CompilationUnit> astParser2 = new CustomASTParser();
        CompilationUnit parsedData2 = astParser2.parse(testCode2);
        ASTOverallCompare.compare(parsedData1, parsedData2);
    }
}
