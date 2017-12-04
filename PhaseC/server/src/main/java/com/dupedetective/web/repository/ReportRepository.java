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
    /**
     * Get reports by the Submission id
     * @param submissionId a submission id
     * @return A list of Reports for the given submission id
     */
    List<Report> findReportsBySubmissionId(String submissionId);

    /**
     * Find report by reference file id and similar file id
     * @param refFileId reference file id
     * @param similarFileId similar file id
     * @return Report with given file ids
     */
    Report findReportByRefFileIdAndSimilarFileId(String refFileId, String similarFileId);
}