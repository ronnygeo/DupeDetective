package cs5500.project.spring.data;

import org.mongojack.MongoCollection;
import org.springframework.data.annotation.Id;

import java.util.List;
@MongoCollection(name = "reports")
public class Report{
	
	@Id private String id;
	private int submissionId;
	private int score;
	private List<ReportItem> items;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(int submissionId) {
		this.submissionId = submissionId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<ReportItem> getItems() {
		return items;
	}

	public void setItems(List<ReportItem> items) {
		this.items = items;
	}
}
