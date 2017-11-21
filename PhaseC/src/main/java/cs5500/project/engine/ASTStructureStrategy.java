package cs5500.project.engine;

import cs5500.project.engine.ast.ASTStructureCompare;
import cs5500.project.engine.ast.ASTStructureVisitor;
import cs5500.project.engine.ast.CustomASTParser;
import cs5500.project.db.ReportItem;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.util.List;

/**
 * AST Strategy for code structure
 */
public class ASTStructureStrategy implements PDStrategy {
	/**
	 * Method to invoke the plagiarism detection inside the given assignment
	 */
	@Override
	public List<ReportItem> checkPlagiarism(String testCode1, String testCode2) {
		Parser<CompilationUnit> astParser = new CustomASTParser();
		CompilationUnit cu1 = astParser.parse(testCode1);
		CompilationUnit cu2 = astParser.parse(testCode2);

		ASTVisitor visitor1 = new ASTStructureVisitor();
		ASTVisitor visitor2 = new ASTStructureVisitor();
		cu1.accept(visitor1);
		cu2.accept(visitor2);
		return new ASTStructureCompare().compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList());
	}
}
