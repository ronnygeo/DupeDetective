package engine.ast.tests;

import cs5500.project.engine.ast.CustomASTParser;

public class ASTParserTests {
    String code = "public class A { int i = 9;  \n int j; \n ArrayList<Integer> al = new ArrayList<Integer>();j=1000; }";
    CustomASTParser astParser = new CustomASTParser(code);

}
