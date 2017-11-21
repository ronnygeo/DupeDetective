package cs5500.project.spring;

import cs5500.project.db.Submission;
import org.springframework.stereotype.Service;

/**
 * Submission service to check if submission is valid
 */
@Service
public class SubmissionService {

    /**
     * @param submission submission object to check
     * @return whether submission is valid or not
     */
        public boolean isValid(Submission submission) {
            return submission != null
                    && submission.getFilecontent() != null
                    && submission.getAssignmentId() != null;
        }
}
