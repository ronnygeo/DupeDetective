package cs5500.project.engine;

import cs5500.project.engine.ast.*;
import cs5500.project.data.ReportLine;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.util.List;

/**
 * AST Strategy for loop comparison
 */
public class ASTLoopStrategy implements PDStrategy {

	/**
	 * Method to invoke the plagiarism detection inside the given assignment
	 */
	@Override
	public List<ReportLine> checkPlagiarism(String testCode1, String testCode2) {
		Parser<CompilationUnit> astParser = new CustomASTParser();
		CompilationUnit cu1 = astParser.parse(testCode1);
		CompilationUnit cu2 = astParser.parse(testCode2);

		ASTVisitor visitor1 = new ASTLoopVisitor();
		ASTVisitor visitor2 = new ASTLoopVisitor();
		cu1.accept(visitor1);
		cu2.accept(visitor2);

		CustomComparator<List<ASTHashObject>> astlc = new ASTParentCompare();
		return astlc.compare(((ASTLoopVisitor) visitor1).getList(), ((ASTLoopVisitor) visitor2).getList());
	}
}
