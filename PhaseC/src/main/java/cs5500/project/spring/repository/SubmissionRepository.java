package cs5500.project.spring.repository;


import java.util.List;
import cs5500.project.db.Submission;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * SubmissionRepository class which extends the MongoRepository and queries the Submission
 * table in the database
 */
@RepositoryRestResource(collectionResourceRel = "submissions", path = "submissions")
public interface SubmissionRepository extends MongoRepository<Submission, String> {

	/**
	 * method to return a list of submissions with the given assignment Id
	 * @param assignmentId assignment id
	 * @return list of Submissions
	 */
	@Query("{ 'assignmentId' : ?0 }")
	List<Submission> findSubmissionsByAssignmentId(@Param("assignmentId") String assignmentId);

	/**
	 * method that returns a list of submissions with the given studentId
	 * @param studentId studentId
	 * @return list of Submissions
	 */
		List<Submission> findSubmissionsByStudentId(@Param("studentId") String studentId);
}