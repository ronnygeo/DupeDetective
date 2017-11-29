import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {SubmissionService} from "../../services/submission.service";
import {ReportService} from "../../services/report.service";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-comparedocuments',
  templateUrl: './comparedocuments.component.html',
  styleUrls: ['./comparedocuments.component.css']
})
export class ComparedocumentsComponent implements OnInit {

  @Input() model;
  @Input() refFileId;
  @Input() similarFileId;
  @Input() student1;
  @Input() student2;

  private doc1: string[];
  private doc2: string[];

  constructor(public activeModal: NgbActiveModal,
              private submissionService: SubmissionService,
              private reportService: ReportService,
              private userService: UserService) { }

  /**
   * On page load
   */
  ngOnInit() {
    // this.getStudentNames();
    this.getDocuments();
  }

  // getStudentNames() {
  //   this.userService.getUser()
  // }

  /**
   * Get both the documents
   */
  getDocuments() {
    this.submissionService.getSubmission(this.refFileId).subscribe(submission => {
      this.doc1 = submission.filecontent.split("\n");
    });
    this.submissionService.getSubmission(this.similarFileId).subscribe(submission => {
      this.doc2 = submission.filecontent.split("\n");
    });
  }
}
