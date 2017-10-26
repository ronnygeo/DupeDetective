package phaseb;

public interface Report {
    /**
     * Provided a submission ID, returns the generated report for that student's submission
     *
     * @param SubmissionID
     * @return Report
     */
    public Report getReport(int submissionID);

    /**
     * For a provided submission ID, returns the calculated score of plagiarism with the other submissions
     *
     * @param submissionID
     * @return Score of plagiarism
     */
    public int getScore(int submissionID);

    /**
     * For a provided submission ID, returns an array of scores compared to each submission individually
     *
     * @param submissionID
     * @return
     */
    public int[] getAllScores(int submissionID);

}