package cs5500.project.db;

import com.mongodb.DBObject;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Submission Object that stores information about submission
 */
public class Submission {

    /**
     * @param id
     * @param assignmentId
     * @param studentId
     */
    public Submission(String id, String assignmentId, String studentId) {
        super();
        this.id = id;
        this.assignmentId = assignmentId;
        this.studentId = studentId;
    }

    /**
     * Default Constructor
     */
    public Submission() {}

    /**
     * @param name
     * @param studentId
     * @param assignmentId
     * @param submittedOn
     * @param filename
     * @param filecontent
     * @param checksum
     */
    public Submission(String name, String studentId, String assignmentId, String submittedOn, String filename, String filecontent, String checksum) {
        this.name = name;
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.submittedOn = submittedOn;
        this.filename = filename;
        this.filecontent = filecontent;
        this.checksum = checksum;
    }

    /**
     * @return the id of the submission
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id of the submission
     */
    public void setId(String id) {
        this.id = id;
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
     * @return the checksum
     */
    public String getChecksum() {
        return checksum;
    }

    /**
     * @param checksum the checksum
     */
    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    /**
     * Create a Submission Object from the given mongo Object
     * @param obj A mongo DB Object
     */
    public void createFromMongoObj(DBObject obj) {
        id = obj.get("id").toString();
        name = obj.get("name").toString();
        studentId = obj.get("studentId").toString();
        assignmentId = obj.get("assignmentId").toString();
        submittedOn = obj.get("submittedOn").toString();
        filename = obj.get("filename").toString();
        filecontent = obj.get("filecontent").toString();
        checksum = obj.get("checksum").toString();

    }

    @Id
    private String id;
    private String name;
    private String studentId;
    private String assignmentId;
    private String submittedOn;
    private String filename;
    private String filecontent;
    private String checksum;
}
