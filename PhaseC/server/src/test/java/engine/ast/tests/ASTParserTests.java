package engine.ast.tests;

import com.dupedetective.engine.Parser;
import com.dupedetective.engine.ast.CustomASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * AST Parser tests
 */
public class ASTParserTests {

    @Test
    public void testCodeAST() {
        String testCode = "public class A { int i = 9;  \n int j;\n j=1+2; \n ArrayList<Integer> al = new ArrayList<Integer>();j=1000; }";
        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit parsedData = astParser.parse(testCode);
        assertNotNull(parsedData instanceof org.eclipse.jdt.core.dom.CompilationUnit);
    }

}
