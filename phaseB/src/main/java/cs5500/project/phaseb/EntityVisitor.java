package cs5500.project.phaseb;

/**
 * Interface provides the visit methods for all Entities of the system
 */
public interface EntityVisitor {

    /**
     * Visitor method to visit instance of Student
     *
     * @param student
     */
    public void visit(Student student);

    /**
     * Visitor method to visit instance of Grader
     *
     * @param grader
     */
    public void visit(Grader grader);

    /**
     * Visitor method to visit instance of Assignment
     *
     * @param assignment
     */
    public void visit(Assignment assignment);

    /**
     * Visitor method to visit instance of Submission
     *
     * @param submission
     */
    public void visit(Submission submission);

    /**
     * Visitor method to visit instance of File
     *
     * @param file
     */
    public void visit(FileObj file);

}