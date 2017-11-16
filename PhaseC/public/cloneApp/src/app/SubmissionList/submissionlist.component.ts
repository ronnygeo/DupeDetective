import { Component, OnInit, Input } from '@angular/core';
import {Assignment} from "../assignment";
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import {AssignmentService} from "../assignment.service";


@Component({
  selector: 'app-submission-list',
  templateUrl: './submissionlist.component.html',
  styleUrls: ['./submissionlist.component.css']
})
export class SubmissionListComponent implements OnInit {

  private assignment: Assignment;

  constructor(private route: ActivatedRoute,
              private assignmentService: AssignmentService,
              private location: Location) {}

  ngOnInit() {
    this.getAssignment();
  }

  getAssignment(): void {
    const id = +this.route.snapshot.paramMap.get('assignmentId');
    this.assignmentService.getAssignment(id)
      .subscribe(assignment => this.assignment = assignment);
}
}
