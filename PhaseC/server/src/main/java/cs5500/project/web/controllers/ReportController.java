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
@RequestMapping("/api")
@CrossOrigin("*")
public class ReportController {
    @Autowired
    ReportRepository reportRepository;

    /**
	 * Method which returns a list of all the reports
	 */
    @GetMapping("/reports")
    public List<Report> getAllReports() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return reportRepository.findAll(sortByCreatedAtDesc);
    }

    /**
	 * Method which returns a list of all the reports with the specified file id
	 */
    @GetMapping("/reports/single")
    public Report getReportByIds(@RequestParam(value = "refFileId", required = false) String refFileId, @RequestParam(value = "similarFileId", required = false) String similarFileId) {
        return reportRepository.findReportByRefFileIdAndSimilarFileId(refFileId, similarFileId);
    }

    /**
	 * Method which returns a list of all the reports
	 */
    @GetMapping("/submissions/{id}/reports")
    public List<Report> getReportsBySubmissionId(@PathVariable("id") String submissionId) {
        return reportRepository.findReportsBySubmissionId(submissionId);
    }

    /**
	 * Method which takes as input a report id and returns the report object with the particular id
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
	 * Method which takes as input an report id and deletes the particular report from the report table
	 */
    @DeleteMapping(value="/reports/{id}")
    public void deleteReport(@PathVariable("id") String id) {
        reportRepository.delete(id);
    }
}

