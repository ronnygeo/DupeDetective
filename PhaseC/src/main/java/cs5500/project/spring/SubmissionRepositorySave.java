package cs5500.project.spring;

import cs5500.project.db.Submission;
import org.springframework.stereotype.Service;

/**
 * Implementation of save submission
 */
@Service
public class SubmissionRepositorySave {
    /**
     * method to return a list of submissions with the given assignment Id
     *
     * @param submission Submission Object
     */
    public void persist(Submission submission) {
        //TODO: Save to mongo
        System.out.println("Saving to mongo.");
    }
}
