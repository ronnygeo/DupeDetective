package cs5500.project.engine;

import cs5500.project.engine.ast.ASTHashObject;
import cs5500.project.engine.ast.ASTStructureCompare;
import cs5500.project.engine.ast.ASTStructureVisitor;
import cs5500.project.engine.ast.CustomASTParser;
import cs5500.project.data.ReportLine;
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
	public List<ReportLine> checkPlagiarism(String testCode1, String testCode2) {
		Parser<CompilationUnit> astParser = new CustomASTParser();
		CompilationUnit cu1 = astParser.parse(testCode1);
		CompilationUnit cu2 = astParser.parse(testCode2);

		ASTVisitor visitor1 = new ASTStructureVisitor();
		ASTVisitor visitor2 = new ASTStructureVisitor();
		cu1.accept(visitor1);
		cu2.accept(visitor2);
		CustomComparator<List<ASTHashObject>> astsc = new ASTStructureCompare();
		return astsc.compare(((ASTStructureVisitor) visitor1).getList(), ((ASTStructureVisitor) visitor2).getList());
	}
}
