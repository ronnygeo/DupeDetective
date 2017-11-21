package cs5500.project.engine;

import cs5500.project.db.ReportItem;

import java.util.List;

/**
 * Plagiarism detection strategy interface that defines common operations to perform on an Assignment
 */
public interface PDStrategy {

    /**
     * Method to invoke the plagiarism detection inside the given assignment
     */
    public List<ReportItem> checkPlagiarism(String testCode1, String testCode2);
}
