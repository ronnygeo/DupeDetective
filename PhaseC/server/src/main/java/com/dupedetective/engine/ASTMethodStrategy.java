package com.dupedetective.engine;

import com.dupedetective.data.ReportLine;
import com.dupedetective.engine.ast.ASTHashObject;
import com.dupedetective.engine.ast.CustomASTParser;
import com.dupedetective.engine.ast.compare.ASTParentCompare;
import com.dupedetective.engine.ast.visitor.ASTMethodVisitor;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.util.List;

/**
 * AST Strategy for method comparison
 */
public class ASTMethodStrategy implements PDStrategy {
	/**
	 * Method to invoke the plagiarism detection inside the given assignment
	 */
	@Override
	public List<ReportLine> checkPlagiarism(String testCode1, String testCode2) {
		Parser<CompilationUnit> astParser = new CustomASTParser();
		CompilationUnit cu1 = astParser.parse(testCode1);
		CompilationUnit cu2 = astParser.parse(testCode2);

		ASTVisitor visitor1 = new ASTMethodVisitor();
		ASTVisitor visitor2 = new ASTMethodVisitor();
		cu1.accept(visitor1);
		cu2.accept(visitor2);
		CustomComparator<List<ASTHashObject>> astmc = new ASTParentCompare();
		return astmc.compare(((ASTMethodVisitor) visitor1).getList(), ((ASTMethodVisitor) visitor2).getList());
	}
}
