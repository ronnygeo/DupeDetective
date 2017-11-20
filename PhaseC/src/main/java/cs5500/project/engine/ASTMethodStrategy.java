package cs5500.project.engine;

import cs5500.project.engine.ast.*;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * AST Strategy for method comparison
 */
public class ASTMethodStrategy implements PDStrategy {
	/**
	 * Method to invoke the plagiarism detection inside the given assignment
	 */
	@Override
	public void checkPlagiarism() {
		String testCode = "package com.example.test;\nimport org.java.*; \n public class A { public A() {}; public void main(String[] args, String t) {" +
				"i = k+2;" +
				"System.out.println(\"Hello World\");} }\n";

		String testCode2 = "package com.example.test;\nimport org.java.*; \n public class B { public B() {}; public void main(String[] args, String test) {" +
				"i = j+2;" + "System.out.println(\"Hello World\");} }\n";
		Parser<CompilationUnit> astParser = new CustomASTParser();
		CompilationUnit cu = astParser.parse(testCode);
		CompilationUnit cu2 = astParser.parse(testCode2);

		ASTVisitor visitor1 = new ASTMethodVisitor();
		ASTVisitor visitor2 = new ASTMethodVisitor();
		cu.accept(visitor1);
		cu2.accept(visitor2);
		new ASTMethodCompare().compare(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList());
	}
}
