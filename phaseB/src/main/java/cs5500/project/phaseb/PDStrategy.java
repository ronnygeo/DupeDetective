package cs5500.project.phaseb;

/**
 * Plagiarism detection strategy interface that defines common operations to perform on an Assignment
 */
public interface PDStrategy {

    /**
     * Method to invoke the plagiarism detection inside the given assignment
     * @param a,An Assignment object to check plagiarism in
     */
    public void checkPlagiarism(Assignment a);
}
