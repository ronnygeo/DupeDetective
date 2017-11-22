package cs5500.project.db;

import com.mongodb.DBObject;
import org.springframework.data.annotation.Id;

/**
 * Submission Object that stores information about submission
 */
public class Submission {

    /**
     * @param id id
     * @param assignmentId assignment id
     * @param studentId student id
     */
    public Submission(String id, String assignmentId, String studentId) {
        this.Id = id;
        this.assignmentId = assignmentId;
        this.studentId = studentId;
    }

    /**
     * Default Constructor
     */
    public Submission() {}

    /**
     * @param name name of submission
     * @param studentId student id
     * @param assignmentId assignment id
     * @param submittedOn date submitted on
     * @param filename filename
     * @param filecontent content of the file
     */
    public Submission(String name, String studentId, String assignmentId, String submittedOn, String filename, String filecontent) {
        this.name = name;
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.submittedOn = submittedOn;
        this.filename = filename;
        this.filecontent = filecontent;
    }

    /**
     * @return the id of the submission
     */
    public String getId() {
        return Id;
    }

    /**
     * @param id the id of the submission
     */
    public void setId(String id) {
        this.Id = id;
    }

    /**
     * @return the name of the submission
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name of the submission
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the student id
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId  the student id
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the assignment id
     */
    public String getAssignmentId() {
        return assignmentId;
    }

    /**
     * @param assignmentId the assignment id
     */
    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    /**
     * @return the submitted date
     */
    public String getSubmittedOn() {
        return submittedOn;
    }

    /**
     * @param submittedOn the submitted date
     */
    public void setSubmittedOn(String submittedOn) {
        this.submittedOn = submittedOn;
    }

    /**
     * @return the file name
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the file name
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the file content
     */
    public String getFilecontent() {
        return filecontent;
    }

    /**
     * @param filecontent the file content
     */
    public void setFilecontent(String filecontent) {
        this.filecontent = filecontent;
    }


    /**
     * Create a Submission Object from the given mongo Object
     * @param obj A mongo DB Object
     */
    public void createFromMongoObj(DBObject obj) {
        Id = checkNull(obj.get("_id"));
        name = checkNull(obj.get("name"));
        studentId = checkNull(obj.get("studentId"));
        assignmentId = checkNull(obj.get("assignmentId"));
        submittedOn = checkNull(obj.get("submittedOn"));
        filename = checkNull(obj.get("filename"));
        filecontent = checkNull(obj.get("filecontent"));
    }

    /**
     * @param val
     * @return
     */
    private String checkNull(Object val) {
        return val != null? val.toString(): "";
    }

    @Id
    private String Id;
    private String name;
    private String studentId;
    private String assignmentId;
    private String submittedOn;
    private String filename;
    private String filecontent;
}
