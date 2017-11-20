package cs5500.project.spring.data;

import org.springframework.data.annotation.Id;

public class Report{
	
	@Id private String id;
	private int submissionId;
	private int score;
	
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
}
