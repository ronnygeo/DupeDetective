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
        String testCode = "public class A { int i = 9;  \n int j;\n j = 1+2; }";
        Parser<CompilationUnit> astParser1 = new CustomASTParser();
        CompilationUnit cu = astParser1.parse(testCode);
        ASTStructureVisitor visitor = new ASTStructureVisitor();
        cu.accept(visitor);
//        System.out.println(visitor.getNodes().toString());
    }
}
