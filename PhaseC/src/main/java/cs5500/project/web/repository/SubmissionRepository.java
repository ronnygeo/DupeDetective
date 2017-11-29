package cs5500.project.web.repository;


import cs5500.project.data.Submission;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SubmissionRepository class which extends the MongoRepository and queries the Submission
 * table in the database
 */
@Repository
public interface SubmissionRepository extends MongoRepository<Submission, String> {
    List<Submission> findSubmissionByAssignmentId(String assignmentId);
    Submission findSubmissionByAssignmentIdAndStudentId(String assignmentId, String studentId);
}