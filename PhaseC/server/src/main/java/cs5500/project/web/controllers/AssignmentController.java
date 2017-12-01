package cs5500.project.web.controllers;

import cs5500.project.data.Assignment;
import cs5500.project.engine.Runner;
import cs5500.project.web.repository.AssignmentRepository;
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
@RequestMapping("/api")
@CrossOrigin("*")
public class AssignmentController {
    @Autowired
    AssignmentRepository assignmentRepository;

    @GetMapping("/assignments")
    public List<Assignment> getAllAssignments() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return assignmentRepository.findAll(sortByCreatedAtDesc);
    }

    @PostMapping("/assignments")
    public Assignment createAssignment(@Valid @RequestBody Assignment assignment) {
        assignment.setAnalyzed(false);
        assignment.setCreationDate(LocalDateTime.now().toString());
        return assignmentRepository.save(assignment);
    }

    @GetMapping(value="/assignments/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable("id") String id) {
        Assignment assignment = assignmentRepository.findOne(id);
        if(assignment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(assignment, HttpStatus.OK);
        }
    }

    @PutMapping(value="/assignments/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable("id") String id,
                                           @Valid @RequestBody Assignment assignment) {
        Assignment assignmentData = assignmentRepository.findOne(id);
        if(assignmentData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        assignmentData.setName(assignment.getName());
        assignmentData.setCourse(assignment.getCourse());
        assignmentData.setDueDate(assignment.getDueDate());
        assignmentData.setYear(assignment.getYear());
        assignmentData.setAnalyzed(assignment.isAnalyzed());
        Assignment updatedAssignment = assignmentRepository.save(assignmentData);
        return new ResponseEntity<>(updatedAssignment, HttpStatus.OK);
    }

    @DeleteMapping(value="/assignments/{id}")
    public void deleteAssignment(@PathVariable("id") String id) {
        assignmentRepository.delete(id);
    }

    /**
     * Start the analyze process for given assignment id
     * @param id assignment id to process
     * @return a promise of string
     */
    @PostMapping(value = "/assignments/{id}/analyze")
    public DeferredResult<String> analyze(@PathVariable("id") String id) {
        DeferredResult<String> defResult = new DeferredResult<>();

        new Thread(() -> {
            Runner.analyze(id);
            String apiResponse = "Analysis complete.";
            defResult.setResult(apiResponse);
        }).start();

        return defResult;
    }
}

