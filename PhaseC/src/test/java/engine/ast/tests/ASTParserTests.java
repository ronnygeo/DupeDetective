package engine.ast.tests;

import cs5500.project.engine.Parser;
import cs5500.project.engine.ast.CustomASTParser;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ASTParserTests {

    @Test
    public void testCodeAST() {
        String testCode = "public class A { int i = 9;  \n int j;\n j=1+2; \n ArrayList<Integer> al = new ArrayList<Integer>();j=1000; }";
        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit parsedData = astParser.parse(testCode);
        assertNotNull(parsedData instanceof org.eclipse.jdt.core.dom.CompilationUnit);
    }

}
