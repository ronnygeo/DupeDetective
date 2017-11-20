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
 * The Component that creates the Report page
 */
@Component({
  selector: 'app-submission-list',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css'],
  entryComponents: [ComparedocumentsComponent]
})
export class ReportComponent implements OnInit {

  private assignment: Assignment;
  private assignments: Assignment[];
  private student1: User;
  private student2: User;
  private students: User[];
  private exactCopy = false;
  private report: Report;

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

  // Get the assignment
  getReport(): void {
      if (this.route.snapshot.paramMap.get('submissionId') != null && this.route.snapshot.paramMap.get('assignmentId') !== "") {
      const id = +this.route.snapshot.paramMap.get('submissionId');
      this.reportService.getReport(id)
        .subscribe(report => this.report = report);
    } else {
      this.reportService.getReport(1)
        .subscribe(report => this.report = report);
    }
  }

  // Go back to previous page
  goBack(): void {
    this.location.back();
  }

  // Open the modal to display comparison
  open(model) {
    const modalRef = this.modalService.open(ComparedocumentsComponent);
    modalRef.componentInstance.model = model;
  }

}
