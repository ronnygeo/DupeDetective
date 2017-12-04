package com.dupedetective.web.controllers;

import com.dupedetective.data.Report;
import com.dupedetective.web.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Report controller
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ReportController {
    @Autowired
    ReportRepository reportRepository;

    /**
     * Get all reports
     * @return List of Reports
     */
    @GetMapping("/reports")
    public List<Report> getAllReports() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return reportRepository.findAll(sortByCreatedAtDesc);
    }

    /**
     * Get Report by reference and similar file Id
     * @param refFileId reference file id
     * @param similarFileId similar file id
     * @return Report object
     */
    @GetMapping("/reports/single")
    public Report getReportByIds(@RequestParam(value = "refFileId", required = false) String refFileId, @RequestParam(value = "similarFileId", required = false) String similarFileId) {
        return reportRepository.findReportByRefFileIdAndSimilarFileId(refFileId, similarFileId);
    }

    /**
     * Get a report by Submission id
     * @param submissionId submission id
     * @return a List of Reports
     */
    @GetMapping("/submissions/{id}/reports")
    public List<Report> getReportsBySubmissionId(@PathVariable("id") String submissionId) {
        return reportRepository.findReportsBySubmissionId(submissionId);
    }

    /**
     * Get a report by given id
     * @param id report id
     * @return a Report
     */
    @GetMapping(value="/reports/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable("id") String id) {
        Report report = reportRepository.findOne(id);
        if(report == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(report, HttpStatus.OK);
        }
    }

    /**
     * Delete a report with given id
     * @param id report id
     */
    @DeleteMapping(value="/reports/{id}")
    public void deleteReport(@PathVariable("id") String id) {
        reportRepository.delete(id);
    }
}

