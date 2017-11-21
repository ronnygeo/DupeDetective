package cs5500.project.db;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * Assignment class which has details about an assignment for example the id,course,
 * year, date it was analyzed,due date etc
 */

public class Assignment {
	
	//constructor for initialization
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
	 * @return
	 */
	// getter and setter method for Id
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	// getter method for assignment name
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	// setter method for assignment name
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	// getter method for course name
	public String getCourse() {
		return course;
	}

	/**
	 * @param course
	 */
	// setter method for course name
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * @return
	 */
	// getter method for year attribute
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 */
	// setter method for year attribute
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
	 * @return
	 */
	// setter and getter methods for dueDate attribute
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return
	 */
	// setter and getter methods for created date attribute
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
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
