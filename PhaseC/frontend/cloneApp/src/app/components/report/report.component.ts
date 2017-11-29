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
  private plagiarised = false;
  private selectedReport: Report;
  private winnowingScore: number;
  private structureScore: number;
  private loopScore: number;
  private methodScore: number;

  constructor(private route: ActivatedRoute,
              private reportService: ReportService,
              private location: Location,
              private modalService: NgbModal,
              private assignmentService: AssignmentService,
              private userService: UserService,
              private submissionService: SubmissionService) {}

  /**
   * On page load
   */
  ngOnInit() {
    this.getReport();
    this.getAllAssignments();
    this.getAllUsers();
  }

  /**
   * Gets all the users
   */
  getAllUsers() {
    this.userService.getUsers().subscribe(users => this.students = users.filter(u => u.grader === false));
  }

  /**
   * Gets all the assignments
   */
  getAllAssignments() {
    this.assignmentService.getAssignments().subscribe(assignments => this.assignments = assignments);
  }

  /**
   * Get student from submission
   */
  getStudentsFromSubmission() {
    this.submissionService.getSubmission(this.selectedReport.refFileId)
      .subscribe(submission => {
        this.student1 = submission.studentId;
        this.selectedAssignment = submission.assignmentId;
      });
    this.submissionService.getSubmission(this.selectedReport.similarFileId)
      .subscribe(submission => {
        this.student2 = submission["studentId"];
      });
  }

  /**
   * Get the assignment
   */
  getReport(): void {
    if (this.route.snapshot.paramMap.get('submissionId') != null && this.route.snapshot.paramMap.get('assignmentId') !== "") {
      const submissionId = this.route.snapshot.paramMap.get('submissionId');
      const assignmentId = this.route.snapshot.paramMap.get('assignmentId');
      this.submissionService.getReportsBySubmissionId(submissionId)
        .subscribe(reports => {
          this.reports = reports;
          if (reports.length > 0) {
            this.selectedReport = reports[0];
            this.getStudentsFromSubmission();
            this.fetchScores();
          }
        });
    } else {
      this.reportService.getAllReports()
        .subscribe(reports => {
          this.reports = reports;
          this.selectedReport = reports[0];
          this.getStudentsFromSubmission();
          this.fetchScores();
        });
    }
  }

  /**
   * Fetch scores from report obj
   */
  fetchScores() {
    for (const model of this.selectedReport.models) {
      // console.log(model.mothis.getStudentsFromSubmission();del)
      switch (model.model) {
        case 1: this.structureScore = model.score; break;
        case 2: this.loopScore = model.score; break;
        case 3: this.methodScore = model.score; break;
        case 5: this.winnowingScore = model.score; break;
      }
    }
  }

  /**
   * Get the assignment
   * @param {string} assignmentId
   * @param {string} refFileId
   * @param {string} similarFileId
   */
  getReportByIds(assignmentId: string, refFileId: string, similarFileId: string): void {
      if (refFileId !== similarFileId) {
    console.log(`ref file id: ${refFileId}, similar file id: ${similarFileId}`);
        this.reportService.getReportByIds(refFileId, similarFileId)
          .subscribe(report => {
            this.selectedReport = report;
            console.log(report);
            this.fetchScores();
          });
      }
  }

  /**
   * update ModelReport on change
   */
  updateReport() {
    this.submissionService.getSubmissionByStudentAssignment(this.selectedAssignment, this.student1).subscribe(submission => {
      const refFileId = submission.id;
      this.submissionService.getSubmissionByStudentAssignment(this.selectedAssignment, this.student2).subscribe(submission2 => {
        const similarFileId = submission2.id;
        this.getReportByIds(this.selectedAssignment, refFileId, similarFileId);
      });
    });
  }

  /**
   * Go back to previous page
   */
  goBack(): void {
    this.location.back();
  }

  /**
   * Open the modal to display comparison
   */
  open(model) {
    const modalRef = this.modalService.open(ComparedocumentsComponent);
    modalRef.componentInstance.model = model;
    modalRef.componentInstance.refFileId = this.selectedReport["refFileId"];
    modalRef.componentInstance.similarFileId = this.selectedReport["similarFileId"];
    modalRef.componentInstance.student1 = this.student1;
    modalRef.componentInstance.student2 = this.student2;
  }
}
