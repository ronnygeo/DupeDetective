package com.dupedetective.web.controllers;

import com.dupedetective.data.Submission;
import com.dupedetective.web.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Submission controller
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SubmissionController {
    @Autowired
    SubmissionRepository submissionRepository;

    /**
     * Get all submissions
     * @return a list of Submissions
     */
    @GetMapping("/submissions")
    public List<Submission> getAllSubmissions() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return submissionRepository.findAll(sortByCreatedAtDesc);
    }

    /**
     * Get Submissions by Assignment id
     * @param id assignment id
     * @return a List of Submissions
     */
    @GetMapping("/assignments/{assignmentId}/submissions")
    public List<Submission> getAllSubmissionsByAssignmentId(@PathVariable("assignmentId") String id) {
        return submissionRepository.findSubmissionByAssignmentId(id);
    }

    /**
     * Get Submissions by Student Id
     * @param assignmentId assignment id
     * @param studentId student id
     * @return a Submission Object
     */
    @GetMapping("/submissions/student")
    public Submission getAllSubmissionsByAssignmentId(@RequestParam(value="assignmentId") String assignmentId, @RequestParam(value="studentId") String studentId) {
        return submissionRepository.findSubmissionByAssignmentIdAndStudentId(assignmentId, studentId);
    }

    /**
     * Create a new Submission
     * @param submission Submission object
     * @return the new Submission
     */
    @PostMapping("/submissions")
    public Submission createSubmission(@Valid @RequestBody Submission submission) {
        submission.setSubmittedOn(LocalDateTime.now().toString());
        return submissionRepository.save(submission);
    }

    /**
     * Get Submission by id
     * @param id submission id
     * @return Submission with given id
     */
    @GetMapping(value="/submissions/{id}")
    public ResponseEntity<Submission> getSubmissionById(@PathVariable("id") String id) {
        Submission submission = submissionRepository.findOne(id);
        if(submission == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(submission, HttpStatus.OK);
        }
    }

    /**
     * Update the submission with given id
     * @param id submission id
     * @param submission Submission object
     * @return a Submission
     */
    @PutMapping(value="/submissions/{id}")
    public ResponseEntity<Submission> updateSubmission(@PathVariable("id") String id,
                                           @Valid @RequestBody Submission submission) {
        Submission submissionData = submissionRepository.findOne(id);
        if(submissionData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        submissionData.setName(submission.getName());
        submissionData.setAssignmentId(submission.getAssignmentId());
        submissionData.setFilename(submission.getFilename());
        submissionData.setFilecontent(submission.getFilecontent());
        submissionData.setStudentId(submission.getStudentId());
        submissionData.setSubmittedOn(LocalDateTime.now().toString());
        Submission updatedSubmission = submissionRepository.save(submissionData);
        return new ResponseEntity<>(updatedSubmission, HttpStatus.OK);
    }

    /**
     * Delete a submission
     * @param id submission id
     */
    @DeleteMapping(value="/submissions/{id}")
    public void deleteSubmission(@PathVariable("id") String id) {
        submissionRepository.delete(id);
    }
}

