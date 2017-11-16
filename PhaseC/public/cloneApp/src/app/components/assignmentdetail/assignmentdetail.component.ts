import { Component, OnInit, Input } from '@angular/core';
import {Assignment} from "../../models/assignment";
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import {AssignmentService} from "../../services/assignment.service";

/**
 * The Component that creates the Assignment Detail page
 */
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

  save(): void {
    this.assignmentService.updateAssignment(this.assignment)
      .subscribe(() => this.goBack());
  }

  // Go back to previous page
  goBack(): void {
    this.location.back();
  }
}
