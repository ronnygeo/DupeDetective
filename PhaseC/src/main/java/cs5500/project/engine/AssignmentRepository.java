package cs5500.project.engine;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * AssignmentRepository class which extends the MongoRepository and queries the Assignment 
 * table in the database
 */

@RepositoryRestResource(collectionResourceRel = "assignments", path = "assignments")
public interface AssignmentRepository extends MongoRepository<Assignment, String>{
	
	// method to return a assignments with the given assignment Id
			Assignment findByAssignmentId(@Param("assignId") int assignId);
			
	// method that returns a list of assignments with the given course Id
			List<Assignment> findByCourse(@Param("course") int course);
	
}