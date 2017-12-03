package com.dupedetective.web.repository;


import com.dupedetective.data.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface that generates an analysis about the assignment submissions
 */
@Repository
public interface ReportRepository extends MongoRepository<Report, String>{
    List<Report> findReportsBySubmissionId(String submissionId);

    Report findReportByRefFileIdAndSimilarFileId(String refFileId, String similarFileId);
}