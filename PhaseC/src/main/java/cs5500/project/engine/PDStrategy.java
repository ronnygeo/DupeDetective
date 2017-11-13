package cs5500.project.engine;

/**
 * Plagiarism detection strategy interface that defines common operations to perform on an Assignment
 */
public interface PDStrategy {

    /**
     * Method to invoke the plagiarism detection inside the given assignment
     */
    public void checkPlagiarism();
}
