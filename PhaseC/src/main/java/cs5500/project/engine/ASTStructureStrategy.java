package cs5500.project.engine;

import cs5500.project.engine.ast.ASTStructureCompare;
import cs5500.project.engine.ast.ASTStructureVisitor;
import cs5500.project.engine.ast.CustomASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * AST Strategy for code structure
 */
public class ASTStructureStrategy implements PDStrategy {
	/**
	 * Method to invoke the plagiarism detection inside the given assignment
	 */
	@Override
	public void checkPlagiarism() {
		//TODO: Get list of all files, compare all files with each other
		String testCode1 = "public class A { int j; \n int i = 9; }";
		String testCode2 = "public class B { int i = 9;  \n int j; }";
		Parser<CompilationUnit> astParser = new CustomASTParser();
		CompilationUnit cu1 = astParser.parse(testCode1);
		CompilationUnit cu2 = astParser.parse(testCode2);

		ASTVisitor visitor1 = new ASTStructureVisitor();
		ASTVisitor visitor2 = new ASTStructureVisitor();
		cu1.accept(visitor1);
		cu2.accept(visitor2);
		new ASTStructureCompare().compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList());
	}
}