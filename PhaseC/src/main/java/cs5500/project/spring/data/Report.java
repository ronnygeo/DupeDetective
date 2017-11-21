package cs5500.project.spring.data;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * The Report object
 */
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
		items = new ArrayList<>();
	}

	/**
	 * Default constructor
	 */
	public Report() {
		items = new ArrayList<>();
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
	public List<ReportItem> getItems() {
		return items;
	}

	/**
	 * @param items the lines in the report
	 */
	public void setItems(List<ReportItem> items) {
		this.items = items;
	}

	/**
	 * @param items add these items to the report items
	 */
	public void addItems(List<ReportItem> items) {
		this.items.addAll(items);
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

	@Id private String id;
	private String submissionId;
	private String refFileId;
	private String similarFileId;
	private List<ReportItem> items;

}
