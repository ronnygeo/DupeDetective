package cs5500.project.db;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Assignment class which has details about an assignment for example the id,course,
 * year, date it was analyzed,due date etc
 */
@Document(collection = "assignment")
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
			boolean isAnalyzed, Date dueDate, Date creationDate,
			Date analyzedDate) {
		
		this.Id = id;
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
		return Id;
	}

	/**
	 * @param id id
	 */
	public void setId(String id) {
		this.Id = id;
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
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the due date
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creation date
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return analyzed date attribute
	 */
	public Date getAnalyzedDate() {
		return analyzedDate;
	}

	/**
	 * @param analyzedDate analyzed date attribute
	 */
	public void setAnalyzedDate(Date analyzedDate) {
		this.analyzedDate = analyzedDate;
	}

	@Id private String Id;
	private String name;
	private String course;
	private boolean isAnalyzed;
	private int year;
	private Date dueDate;
	private Date creationDate;
	private Date analyzedDate;
}
