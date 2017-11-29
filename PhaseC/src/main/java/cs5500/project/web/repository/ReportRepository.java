package cs5500.project.web.repository;


import cs5500.project.data.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface that generates an analysis about the assignment submissions
 */
@Repository
public interface ReportRepository extends MongoRepository<Report, String>{}