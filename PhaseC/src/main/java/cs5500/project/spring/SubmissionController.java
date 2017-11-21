package cs5500.project.spring;

import cs5500.project.db.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Submission save controller
 */
@RestController
public class SubmissionController {
        @Autowired
        private SubmissionService submissionService;

        @Autowired private SubmissionRepositorySave submissionRepository;

        @RequestMapping(value = "/submissions/new", method = RequestMethod.POST)
        public ResponseEntity<String> persistSubmission(@RequestBody Submission submission) {
            if (submissionService.isValid(submission)) {
                submissionRepository.persist(submission);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
}

