package cs5500.project.engine;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * SubmissionRepository class which extends the MongoRepository and queries the Submission 
 * table in the database
 */
@RepositoryRestResource(collectionResourceRel = "submissions", path = "submissions")
public interface SubmissionRepository extends MongoRepository<Submission, String>{
	
	// method to return a list of submissions with the given assignment Id
		List<Submission> findByAssignmentId(@Param("assignId") int assignId);
		
	// method that returns a list of submissions with the given studentId
		List<Submission> findByStudentId(@Param("studentId") int studentId);
}