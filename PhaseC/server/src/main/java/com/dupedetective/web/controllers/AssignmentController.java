package com.dupedetective.web.controllers;

import com.dupedetective.data.Assignment;
import com.dupedetective.engine.Runner;
import com.dupedetective.web.repository.AssignmentRepository;
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
 * Assignment controller
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AssignmentController {
    @Autowired
    AssignmentRepository assignmentRepository;

    /**
     * Get all assignments
     * @return a list of Assignments
     */
    @GetMapping("/assignments")
    public List<Assignment> getAllAssignments() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return assignmentRepository.findAll(sortByCreatedAtDesc);
    }

    /**
     * Create an assignment
     * @param assignment an Assignment object
     * @return new Assignment object
     */
    @PostMapping("/assignments")
    public Assignment createAssignment(@Valid @RequestBody Assignment assignment) {
        assignment.setAnalyzed(false);
        assignment.setCreationDate(LocalDateTime.now().toString());
        return assignmentRepository.save(assignment);
    }

    /**
     * Get an assignment by id
     * @param id assignment id
     * @return a Response Entity with Assignment
     */
    @GetMapping(value="/assignments/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable("id") String id) {
        Assignment assignment = assignmentRepository.findOne(id);
        if(assignment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(assignment, HttpStatus.OK);
        }
    }

    /**
     * Update an assignment
     * @param id assignment id
     * @param assignment Assignment object
     * @return new Assignment object
     */
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

    /**
     * Delete an Assignment
     * @param id assignment id
     */
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

