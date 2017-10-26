package cs5500.project.phaseb;

/**
 * Interface that generates an analysis about the assignment submissions
 */
public interface Report {
    /**
     * Provided a submission Id, returns the generated report for that student's submission
     *
     * @param submissionId
     * @return Report
     */
    public Report getReport(int submissionId);

    /**
     * For a provided submission Id, returns the calculated score of plagiarism with the other submissions
     *
     * @param submissionId
     * @return Score of plagiarism
     */
    public int getScore(int submissionId);

    /**
     * For a provided submission Id, returns an array of scores compared to each submission individually
     *
     * @param submissionId
     * @return an array of scores after comparison
     */
    public int[] getAllScores(int submissionId);
}