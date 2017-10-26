package phaseb;

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
     * @return
     */
    public int[] getAllScores(int submissionId);
}