import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {SubmissionService} from "../../services/submission.service";

@Component({
  selector: 'app-comparedocuments',
  templateUrl: './comparedocuments.component.html',
  styleUrls: ['./comparedocuments.component.css']
})
export class ComparedocumentsComponent implements OnInit {

  @Input() model;
  @Input() refFileId;
  @Input() similarFileId;

  private doc1: string[];
  private doc2: string[];

  constructor(public activeModal: NgbActiveModal,
              private submissionService: SubmissionService) { }

  ngOnInit() {
    console.log(this.model, this.refFileId, this.similarFileId);
    this.submissionService.getAllSubmissions().subscribe(submissions => {
      this.doc1 = submissions.filter(s => this.refFileId === s["id"]).map(s => s.filecontent)[0].split("\n");
      this.doc2 = submissions.filter(s => this.similarFileId === s["id"]).map(s => s.filecontent)[0].split("\n");
    });
  }



}
