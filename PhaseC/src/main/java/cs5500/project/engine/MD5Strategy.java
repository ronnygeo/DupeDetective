package cs5500.project.engine;

import cs5500.project.engine.ast.ASTStructureCompare;
import cs5500.project.engine.ast.ASTStructureVisitor;
import cs5500.project.engine.ast.CustomASTParser;
import cs5500.project.engine.md5.MD5Generator;
import cs5500.project.spring.data.ReportItem;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.util.List;

/**
 * AST Strategy for code structure
 */
public class MD5Strategy implements PDStrategy {
	private MD5Generator md5;

	public MD5Strategy() {
		md5 = new MD5Generator();
	}

	/**
	 * Method to invoke the plagiarism detection inside the given assignment
	 */
	@Override
	public List<ReportItem> checkPlagiarism(String testCode1, String testCode2) {
		//TODO: Return the whole file as a report Item
		return null;
	}

	public boolean checkMD5(String testCode1, String testCode2) {
		return md5.getMD5String(testCode1) == md5.getMD5String(testCode2);
	}
}
