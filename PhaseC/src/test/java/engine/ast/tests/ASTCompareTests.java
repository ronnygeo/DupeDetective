package engine.ast.tests;

import cs5500.project.engine.Parser;
import cs5500.project.engine.ast.ASTOverallCompare;
import cs5500.project.engine.ast.CustomASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Test;

public class ASTCompareTests {
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
    public void testCompareVariableNameChanges() {
        String testCode1 = "public class A { int i = 9;  \n int j;\n j=1+2; \n ArrayList<Integer> al = new ArrayList<Integer>();j=1000; }";
        String testCode2 = "public class B { int f = 9;  \n int g;\n g=1+2; \n ArrayList<Integer> al = new ArrayList<Integer>();j=1000; }";
        Parser<CompilationUnit> astParser1 = new CustomASTParser();
        CompilationUnit parsedData1 = astParser1.parse(testCode1);
        Parser<CompilationUnit> astParser2 = new CustomASTParser();
        CompilationUnit parsedData2 = astParser2.parse(testCode2);
        ASTOverallCompare.compare(parsedData1, parsedData2);
    }

    @Test
    public void testCompareDifferentDataTypes() {
        String testCode1 = "public class A { int i = 9;  \n int j;\n j=1+2; \n ArrayList<Integer> al = new ArrayList<Integer>();j=1000; }";
        String testCode2 = "public class B { float i = 9;  \n float j;\n j=1+2; \n ArrayList<Float> al = new ArrayList<Float>();j=1000; }";
        Parser<CompilationUnit> astParser1 = new CustomASTParser();
        CompilationUnit parsedData1 = astParser1.parse(testCode1);
        Parser<CompilationUnit> astParser2 = new CustomASTParser();
        CompilationUnit parsedData2 = astParser2.parse(testCode2);
        ASTOverallCompare.compare(parsedData1, parsedData2);
    }
}
