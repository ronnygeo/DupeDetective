import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import {Submission} from "../../models/submission";
import {SubmissionService} from "../../services/submission.service";

@Component({
  selector: 'app-submission-list',
  templateUrl: './submissionlist.component.html',
  styleUrls: ['./submissionlist.component.css']
})
export class SubmissionListComponent implements OnInit {

  private submissions: Submission[];

  constructor(private route: ActivatedRoute,
              private submissionService: SubmissionService,
              private location: Location) {}

  ngOnInit() {
    this.getSubmissions();
  }

  getSubmissions(): void {
    if (this.route.snapshot.paramMap.get('assignmentId') != null && this.route.snapshot.paramMap.get('assignmentId') !== "") {
      const id: string = this.route.snapshot.paramMap.get('assignmentId');
      console.log(id);
      this.submissionService.getSubmissions(id)
        .subscribe(submission => this.submissions = submission.filter(s => s.assignmentId === id));
      } else {
      this.submissionService.getAllSubmissions()
      .subscribe(submission => this.submissions = submission);
      }
    }
}
