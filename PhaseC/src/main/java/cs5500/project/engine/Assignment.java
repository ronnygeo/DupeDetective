package cs5500.project.engine;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * Assignment class which has details about an assignment for example the id,course,
 * year, date it was analyzed,due date etc
 */

public class Assignment {
	
	@Id private int id;
	private String name;
	private String course;
	private int year;
	private boolean isAnalysed;
	private Date dueDate;
	private Date creationDate;
	private Date analyzedDate;
	
	//constructor for initialization
	public Assignment(int id, String name, String course, int year,
			boolean isAnalysed, Date dueDate, Date creationDate,
			Date analyzedDate) {
		
		this.id = id;
		this.name = name;
		this.course = course;
		this.year = year;
		this.isAnalysed = isAnalysed;
		this.dueDate = dueDate;
		this.creationDate = creationDate;
		this.analyzedDate = analyzedDate;
	}
	
	// getter and setter method for Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	// getter method for assignment name
	public String getName() {
		return name;
	}
	
	// setter method for assignment name
	public void setName(String name) {
		this.name = name;
	}
	
	// getter method for course name
	public String getCourse() {
		return course;
	}
	
	// setter method for course name
	public void setCourse(String course) {
		this.course = course;
	}
	
	// getter method for year attribute
	public int getYear() {
		return year;
	}
	
	// setter method for year attribute
	public void setYear(int year) {
		this.year = year;
	}
	
	// setter and getter methods for isAnalysed attribute
	public boolean isAnalysed() {
		return isAnalysed;
	}
	
	public void setAnalysed(boolean isAnalysed) {
		this.isAnalysed = isAnalysed;
	}
	
	// setter and getter methods for dueDate attribute
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	// setter and getter methods for created date attribute
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	// setter and getter methods for analyzed date attribute
	public Date getAnalyzedDate() {
		return analyzedDate;
	}
	
	public void setAnalyzedDate(Date analyzedDate) {
		this.analyzedDate = analyzedDate;
	}
	
	
}
