package cs5500.project.phaseb;

/**
 * A Detector interface that run the plagiarism detection and generates the report
 */
public interface Detector {

    /**
     * Method to start the plagiarism detection process
     */
    public boolean detectPlagiarism();

    /**
     * Method that creates the records for report generation
     */
    public boolean generateReport();

}
