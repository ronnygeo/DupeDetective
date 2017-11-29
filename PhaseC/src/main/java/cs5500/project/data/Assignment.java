package cs5500.project.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Assignment class which has details about an assignment for example the id,course,
 * year, date it was analyzed,due date etc
 */
@Document(collection = "assignment")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Assignment {

	/**
	 * @param id the id
	 * @param name name of assignment
	 * @param course course
	 * @param year year
	 * @param isAnalyzed is the assignment analyzed
	 * @param dueDate due date for the assignment
	 * @param creationDate creation date
	 * @param analyzedDate date analyzed
	 */
	public Assignment(String id, String name, String course, int year,
			boolean isAnalyzed, String dueDate, String creationDate,
			String analyzedDate) {
		
		this.id = id;
		this.name = name;
		this.course = course;
		this.year = year;
		this.isAnalyzed = isAnalyzed;
		this.dueDate = dueDate;
		this.creationDate = creationDate;
		this.analyzedDate = analyzedDate;
	}

	/**
	 * Default Constructor
	 */
	public Assignment() {}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id id
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the name of the node
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name of the node
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the course of this assignment
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course the course of this assignment
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * @return the year of assignment
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year of assignment
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return whether assignment is analyzed or not
	 */
	public boolean isAnalyzed() {
		return isAnalyzed;
	}

	/**
	 * @param isAnalysed whether assignment is analyzed or not
	 */
	public void setAnalyzed(boolean isAnalysed) {
		this.isAnalyzed = isAnalyzed;
	}

	/**
	 * @return the due date
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the due date
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the creation date
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creation date
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return analyzed date attribute
	 */
	public String getAnalyzedDate() {
		return analyzedDate;
	}

	/**
	 * @param analyzedDate analyzed date attribute
	 */
	public void setAnalyzedDate(String analyzedDate) {
		this.analyzedDate = analyzedDate;
	}

	@Id private String id;
	@NotBlank private String name;
	private String course;
	private boolean isAnalyzed;
	private int year;
	private String dueDate;
	private String creationDate;
	private String analyzedDate;
}
