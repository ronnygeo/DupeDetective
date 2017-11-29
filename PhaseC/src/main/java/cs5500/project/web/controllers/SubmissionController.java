package cs5500.project.web.controllers;

import cs5500.project.data.Submission;
import cs5500.project.engine.Runner;
import cs5500.project.web.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Start analyze controller
 */
@RestController
@CrossOrigin("*")
public class SubmissionController {
    @Autowired
    SubmissionRepository submissionRepository;

    @GetMapping("/submissions")
    public List<Submission> getAllSubmissions() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return submissionRepository.findAll(sortByCreatedAtDesc);
    }

    @GetMapping("/assignments/{assignmentId}/submissions")
    public List<Submission> getAllSubmissionsByAssignmentId(@PathVariable("assignmentId") String id) {
        return submissionRepository.findSubmissionByAssignmentId(id);
    }

    @GetMapping("/submissions/student")
    public Submission getAllSubmissionsByAssignmentId(@RequestParam(value="assignmentId") String assignmentId, @RequestParam(value="studentId") String studentId) {
        return submissionRepository.findSubmissionByAssignmentIdAndStudentId(assignmentId, studentId);
    }

    @PostMapping("/submissions")
    public Submission createSubmission(@Valid @RequestBody Submission submission) {
        submission.setSubmittedOn(LocalDateTime.now().toString());
        return submissionRepository.save(submission);
    }

    @GetMapping(value="/submissions/{id}")
    public ResponseEntity<Submission> getSubmissionById(@PathVariable("id") String id) {
        Submission submission = submissionRepository.findOne(id);
        if(submission == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(submission, HttpStatus.OK);
        }
    }

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

    @DeleteMapping(value="/submissions/{id}")
    public void deleteSubmission(@PathVariable("id") String id) {
        submissionRepository.delete(id);
    }
}

