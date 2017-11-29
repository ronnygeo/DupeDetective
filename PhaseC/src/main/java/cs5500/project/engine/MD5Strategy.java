package cs5500.project.engine;

import cs5500.project.data.ReportLine;
import cs5500.project.engine.md5.MD5Generator;

import java.util.ArrayList;
import java.util.List;

/**
 * AST Strategy for MD5
 */
public class MD5Strategy implements PDStrategy {
	private MD5Generator md5;

	/**
	 * Default constructor
	 */
	public MD5Strategy() {
		md5 = new MD5Generator();
	}

	/**
	 * Method to invoke the plagiarism detection inside the given assignment
	 */
	@Override
	public List<ReportLine> checkPlagiarism(String code1, String code2) {
		List<ReportLine> l = new ArrayList<>();
		ReportLine ri = new ReportLine();
		ri.setModel(Model.MD5.getValue());
		ri.setScore(checkMD5(code1, code2)? 1f:0f);
		l.add(ri);
		return l;
	}

	/**
	 * Checks the MD5 checksums of two files
	 * @param testCode1 First code to check
	 * @param testCode2 Second code to check
	 * @return if the MD5 checksum is same or not
	 */
	public boolean checkMD5(String testCode1, String testCode2) {
		return md5.getMD5String(testCode1) == md5.getMD5String(testCode2);
	}
}
