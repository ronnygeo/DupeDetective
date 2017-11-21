package cs5500.project.spring;


import java.util.List;

import cs5500.project.db.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Interface that generates an analysis about the assignment submissions
 */
@RepositoryRestResource(collectionResourceRel = "reports", path = "reports")
public interface ReportRepository extends MongoRepository<Report, String>{

	/**
	 * method to return a list of reports with the given submission Id
	 * @param submissionId submission id
	 * @return a list of reports
	 */
	List<Report> findReportsBySubmissionId(@Param("submissionId") int submissionId);
}