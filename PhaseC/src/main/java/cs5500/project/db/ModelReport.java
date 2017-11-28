package cs5500.project.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * The ModelReport object
 */
public class ModelReport {


	/**
	 * @param model model id
	 */
	public ModelReport(Integer model) {
		this.model = model;
		lines = new ArrayList<>();
	}

	/**
	 * Default constructor
	 */
	public ModelReport() {
		lines = new ArrayList<>();
	}

	/**
	 * @return the id of the model
	 */
	public Integer getModel() {
		return model;
	}

	/**
	 * @param model the id of the model
	 */
	public void setModel(Integer model) {
		this.model = model;
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
	 * @return total score from the model
	 */
	public float getScore() {
		return score;
	}

	/**
	 * @param score total score from the model
	 */
	public void setScore(float score) {
		this.score = score;
	}

	/**
	 * calculate total score from all the report lines
	 */
	public void computeScore() {
		this.score = (float) lines.stream().mapToDouble(ReportLine::getScore).average().getAsDouble();
	}

	private Integer model;
	private float score;
	private List<ReportLine> lines;
}
