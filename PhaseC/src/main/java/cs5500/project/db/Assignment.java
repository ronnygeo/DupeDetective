package cs5500.project.db;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * Assignment class which has details about an assignment for example the id,course,
 * year, date it was analyzed,due date etc
 */

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
	public Assignment(int id, String name, String course, int year,
			boolean isAnalyzed, Date dueDate, Date creationDate,
			Date analyzedDate) {
		
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id
	 */
	public void setId(int id) {
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

	@Id private int id;
	private String name;
	private String course;
	private int year;
	private boolean isAnalyzed;
	private Date dueDate;
	private Date creationDate;
	private Date analyzedDate;
}
