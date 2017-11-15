import { Component, OnInit, Input } from '@angular/core';
import {Assignment} from "../assignment";
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import {AssignmentService} from "../assignment.service";


@Component({
  selector: 'app-submission-list',
  templateUrl: './assignmentdetail.component.html',
  styleUrls: ['./assignmentdetail.component.css']
})
export class AssignmentDetailComponent implements OnInit {

  private assignment: Assignment;

  constructor(private route: ActivatedRoute,
              private assignmentService: AssignmentService,
              private location: Location) {}

  ngOnInit() {
    this.getAssignment();
  }

  // Get the assignment
  getAssignment(): void {
    const id = +this.route.snapshot.paramMap.get('assignmentId');
    this.assignmentService.getAssignment(id)
      .subscribe(assignment => this.assignment = assignment);
  }

  // Go back to previous page
  goBack(): void {
    this.location.back();
  }
}
