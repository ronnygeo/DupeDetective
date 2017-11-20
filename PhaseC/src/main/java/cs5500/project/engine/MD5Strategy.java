package cs5500.project.engine;

import cs5500.project.engine.ast.ASTStructureCompare;
import cs5500.project.engine.ast.ASTStructureVisitor;
import cs5500.project.engine.ast.CustomASTParser;
import cs5500.project.engine.md5.MD5Generator;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * AST Strategy for code structure
 */
public class MD5Strategy implements PDStrategy {
	/**
	 * Method to invoke the plagiarism detection inside the given assignment
	 */
	@Override
	public float checkPlagiarism(String testCode1, String testCode2) {
		MD5Generator md5 = new MD5Generator();
		return md5.getMD5String(testCode1) == md5.getMD5String(testCode2)? 1.0f: 0.0f;
	}
}
