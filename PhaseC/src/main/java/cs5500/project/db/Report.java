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
	 * @return items the lines in the report
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
	 * @param lines add these items to the report items
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


	public float getOverallScore() {
		return overallScore;
	}

	public void setOverallScore(float overallScore) {
		this.overallScore = overallScore;
	}

	public float getStructureScore() {
		return structureScore;
	}

	public void setStructureScore(float structureScore) {
		this.structureScore = structureScore;
	}

	public float getLoopScore() {
		return loopScore;
	}

	public void setLoopScore(float loopScore) {
		this.loopScore = loopScore;
	}

	public float getMethodScore() {
		return methodScore;
	}

	public void setMethodScore(float methodScore) {
		this.methodScore = methodScore;
	}

	public float getWinnowingScore() {
		return winnowingScore;
	}

	public void setWinnowingScore(float winnowingScore) {
		this.winnowingScore = winnowingScore;
	}

	public boolean isMd5Result() {
		return md5Result;
	}

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
