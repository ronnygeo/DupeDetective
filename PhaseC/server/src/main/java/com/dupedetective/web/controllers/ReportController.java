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
 * Start analyze controller
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ReportController {
    @Autowired
    ReportRepository reportRepository;

    @GetMapping("/reports")
    public List<Report> getAllReports() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return reportRepository.findAll(sortByCreatedAtDesc);
    }

    @GetMapping("/reports/single")
    public Report getReportByIds(@RequestParam(value = "refFileId", required = false) String refFileId, @RequestParam(value = "similarFileId", required = false) String similarFileId) {
        return reportRepository.findReportByRefFileIdAndSimilarFileId(refFileId, similarFileId);
    }

    @GetMapping("/submissions/{id}/reports")
    public List<Report> getReportsBySubmissionId(@PathVariable("id") String submissionId) {
        return reportRepository.findReportsBySubmissionId(submissionId);
    }

    @GetMapping(value="/reports/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable("id") String id) {
        Report report = reportRepository.findOne(id);
        if(report == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(report, HttpStatus.OK);
        }
    }


    @DeleteMapping(value="/reports/{id}")
    public void deleteReport(@PathVariable("id") String id) {
        reportRepository.delete(id);
    }
}

