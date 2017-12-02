package com.dupedetective.engine;

import com.dupedetective.data.ReportLine;

import java.util.List;

/**
 * Plagiarism detection strategy interface that defines common operations to perform on an Assignment
 */
public interface PDStrategy {

    /**
     * Method to invoke the plagiarism detection inside the given assignment
     * @param testCode1 first code to compare
     * @param testCode2 second code to compare
     * @return a list of ReportItems
     */
    public List<ReportLine> checkPlagiarism(String testCode1, String testCode2);
}
