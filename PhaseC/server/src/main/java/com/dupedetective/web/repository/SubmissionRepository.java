package com.dupedetective.web.repository;


import com.dupedetective.data.Submission;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SubmissionRepository class which extends the MongoRepository and queries the Submission
 * table in the database
 */
@Repository
public interface SubmissionRepository extends MongoRepository<Submission, String> {
    /**
     * Find a submission by AssignmentId
     * @param assignmentId assignment id
     * @return A list of submission for the given assignment
     */
    List<Submission> findSubmissionByAssignmentId(String assignmentId);

    /**
     * Find submission by assignment id and student id
     * @param assignmentId assignment id
     * @param studentId student id
     * @return Submission by the given student for given assignment
     */
    Submission findSubmissionByAssignmentIdAndStudentId(String assignmentId, String studentId);
}