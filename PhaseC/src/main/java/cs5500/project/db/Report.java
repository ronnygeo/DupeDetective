package cs5500.project.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * The Report object
 */
@Document(collection="report")
public class Report{


	/**
	 * @param submissionId submission id
	 * @param refFileId reference file id
	 * @param similarFileId similar file id
	 */
	public Report(String submissionId, String refFileId, String similarFileId) {
		this.submissionId = submissionId;
		this.refFileId = refFileId;
		this.similarFileId = similarFileId;
		lines = new ArrayList<>();
	}

	/**
	 * Default constructor
	 */
	public Report() {
		lines = new ArrayList<>();
	}

	/**
	 * @return the id of the report
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id of the report
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the lines in the report
	 */
	public List<ReportLine> getLines() {
		return lines;
	}

	/**
	 * @param lines the lines in the report
	 */
	public void setLines(List<ReportLine> lines) {
		this.lines = lines;
	}

	/**
	 * @param lines add these lines to the report items
	 */
	public void addLines(List<ReportLine> lines) {
		this.lines.addAll(lines);
	}

	/**
	 * @return the reference file id
	 */
	public String getRefFileId() {
		return refFileId;
	}

	/**
	 * @param refFileId the reference file id
	 */
	public void setRefFileId(String refFileId) {
		this.refFileId = refFileId;
	}

	/**
	 * @return the similar file id
	 */
	public String getSimilarFileId() {
		return similarFileId;
	}

	/**
	 * @param similarFileId the similar file id
	 */
	public void setSimilarFileId(String similarFileId) {
		this.similarFileId = similarFileId;
	}

	/**
	 * @return the submission id
	 */
	public String getSubmissionId() {
		return submissionId;
	}

	/**
	 * @param submissionId the submission id
	 */
	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}


	/**
	 * @return overall score of all the models
	 */
	public float getOverallScore() {
		return overallScore;
	}

	/**
	 * @param overallScore overall score of all the models
	 */
	public void setOverallScore(float overallScore) {
		this.overallScore = overallScore;
	}

	/**
	 * @return score from AST structure model
	 */
	public float getStructureScore() {
		return structureScore;
	}

	/**
	 * @param structureScore score from AST structure model
	 */
	public void setStructureScore(float structureScore) {
		this.structureScore = structureScore;
	}

	/**
	 * @return score from AST Loop model
	 */
	public float getLoopScore() {
		return loopScore;
	}

	/**
	 * @param loopScore score from AST Loop model
	 */
	public void setLoopScore(float loopScore) {
		this.loopScore = loopScore;
	}

	/**
	 * @return score from AST method model
	 */
	public float getMethodScore() {
		return methodScore;
	}

	/**
	 * @param methodScore score from AST method model
	 */
	public void setMethodScore(float methodScore) {
		this.methodScore = methodScore;
	}

	/**
	 * @return score from the winnowing mode
	 */
	public float getWinnowingScore() {
		return winnowingScore;
	}

	/**
	 * @param winnowingScore score from the winnowing mode
	 */
	public void setWinnowingScore(float winnowingScore) {
		this.winnowingScore = winnowingScore;
	}

	/**
	 * @return  whether md5 checksum is same or not
	 */
	public boolean isMd5Result() {
		return md5Result;
	}

	/**
	 * @param md5Result whether md5 checksum is same or not
	 */
	public void setMd5Result(boolean md5Result) {
		this.md5Result = md5Result;
	}

	@Id
	private String id;
	private String submissionId;
	private String refFileId;
	private String similarFileId;
	private float overallScore;
	private float structureScore;
	private float loopScore;
	private float methodScore;
	private float winnowingScore;
	private boolean md5Result;
	private List<ReportLine> lines;
}
