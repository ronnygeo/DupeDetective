package cs5500.project.web.controllers;

import cs5500.project.data.Report;
import cs5500.project.web.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Start analyze controller
 */
@RestController
@CrossOrigin("*")
public class ReportController {
    @Autowired
    ReportRepository reportRepository;

    @GetMapping("/reports")
    public List<Report> getAllReports() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return reportRepository.findAll(sortByCreatedAtDesc);
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

    @GetMapping(value="/submissions/{refFileId}/{similarFileId}")
    public Report getReportByFileIds(@PathVariable("refFileId") String refFileId, @PathVariable("similarFileId") String similarFileId) {
        return reportRepository.findReportByRefFileIdAndSimilarFileId(refFileId, similarFileId);
    }

    @DeleteMapping(value="/reports/{id}")
    public void deleteReport(@PathVariable("id") String id) {
        reportRepository.delete(id);
    }
}

