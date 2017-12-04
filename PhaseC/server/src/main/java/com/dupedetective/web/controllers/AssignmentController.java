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
 * Controller class which handles the get, post, put and delete requests for the Assignment object
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AssignmentController {
    @Autowired
    AssignmentRepository assignmentRepository;

    /**
	 * Method which returns a list of all the assignments
	 */
    @GetMapping("/assignments")
    public List<Assignment> getAllAssignments() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return assignmentRepository.findAll(sortByCreatedAtDesc);
    }

    /**
	 * Method which takes as input an assignment object and adds it to the database in the assignment collection
	 */
    @PostMapping("/assignments")
    public Assignment createAssignment(@Valid @RequestBody Assignment assignment) {
        assignment.setAnalyzed(false);
        assignment.setCreationDate(LocalDateTime.now().toString());
        return assignmentRepository.save(assignment);
    }

    /**
	 * Method which takes as input an assignment id and returns the assignment object with the particular id
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
	 * Method which takes as input an assignment id and returns the assignment object with the particular id
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
	 * Method which takes as input an assignment id and deletes the particular assignment from the assignment table
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

