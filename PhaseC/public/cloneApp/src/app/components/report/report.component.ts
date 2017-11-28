import { Component, OnInit, Input } from '@angular/core';
import {Assignment} from "../../models/assignment";
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import {ReportService} from "../../services/report.service";
import {NgbModal, ModalDismissReasons, NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {ComparedocumentsComponent} from "../comparedocuments/comparedocuments.component";
import {AssignmentService} from "../../services/assignment.service";
import {UserService} from "../../services/user.service";
import {User} from "../../models/user";
import {SubmissionService} from "../../services/submission.service";
import {Report} from "../../models/report";

/**
 * The Component that creates the ModelReport page
 */
@Component({
  selector: 'app-submission-list',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css'],
  entryComponents: [ComparedocumentsComponent]
})
export class ReportComponent implements OnInit {

  private selectedAssignment: string;
  private assignments: Assignment[];
  private student1: string;
  private student2: string;
  private students: User[];
  private reports: Report[];
  private selectedReport: Report;

  constructor(private route: ActivatedRoute,
              private reportService: ReportService,
              private location: Location,
              private modalService: NgbModal,
              private assignmentService: AssignmentService,
              private userService: UserService,
              private submissionService: SubmissionService) {}

  ngOnInit() {
    this.getReport();
    this.getAllAssignments();
    this.getAllUsers();
  }

  // Gets all the users
  getAllUsers() {
    this.userService.getUsers().subscribe(users => this.students = users.filter(u => u.grader === false));
  }
  // Gets all the assignments
  getAllAssignments() {
    this.assignmentService.getAssignments().subscribe(assignments => this.assignments = assignments);
  }

  // Get student from submission
  getStudentsFromSubmission() {
    this.selectedReport;
    this.submissionService.getSubmissions(this.selectedReport.refFileId)
      .subscribe(submissions => {
        submissions.filter(s => s["id"] === this.selectedReport.refFileId)
          .map(submission => {
            this.student1 = submission["studentId"];
            this.selectedAssignment = submission.assignmentId;
          });
      });
    this.submissionService.getSubmissions(this.selectedReport["similarFileId"])
      .subscribe(submissions => {
        submissions.filter(s => s["id"] === this.selectedReport["refFileId"])
          .map(submission => this.student2 = submission["studentId"]);
      });
  }

  // Get the assignment
  getReport(): void {
    if (this.route.snapshot.paramMap.get('submissionId') != null && this.route.snapshot.paramMap.get('assignmentId') !== "") {
      const submissionId = this.route.snapshot.paramMap.get('submissionId');
      const assignmentId = this.route.snapshot.paramMap.get('assignmentId');
      console.log(submissionId, " ", assignmentId);
      this.reportService.getAllReports()
        .subscribe(reports => {
          this.reports = reports;
          console.log(reports);
          this.selectedReport = reports.filter(r => r.submissionId === submissionId)[0];
          this.getStudentsFromSubmission();
        });
    } else {
      this.reportService.getAllReports()
        .subscribe(reports => {
          this.reports = reports;
          this.selectedReport = reports[0];
          console.log(this.selectedReport);
          this.getStudentsFromSubmission();
        });
    }
  }

  // Get the assignment
  getReportByIds(assignmentId: string, refFileId: string, similarFileId: string): void {
      if (refFileId !== similarFileId) {
        this.reportService.getReportByIds(assignmentId, refFileId, similarFileId)
          .subscribe(report => {
            this.reports = report;
            this.selectedReport = this.reports.filter(r => r["assignmentId"] === assignmentId &&
              r["refFileId"] === refFileId && r["similarFileId"] === similarFileId)[0];
            console.log(report, assignmentId, refFileId, similarFileId);
          });
      }
  }

  // update ModelReport on change
  updateReport() {
    this.submissionService.getAllSubmissions().subscribe(submissions => {
      const refFileId = submissions.filter(s => s["studentId"] === this.student1).map(s => s["id"])[0];
      const similarFileId = submissions.filter(s => s["studentId"] === this.student2).map(s => s["id"])[0];
      this.getReportByIds(this.selectedAssignment, refFileId, similarFileId);
    });

  }

  // Go back to previous page
  goBack(): void {
    this.location.back();
  }

  // Open the modal to display comparison
  open(model) {
    const modalRef = this.modalService.open(ComparedocumentsComponent);
    modalRef.componentInstance.model = model;
    modalRef.componentInstance.refFileId = this.selectedReport["refFileId"];
    modalRef.componentInstance.similarFileId = this.selectedReport["similarFileId"];
  }
}
