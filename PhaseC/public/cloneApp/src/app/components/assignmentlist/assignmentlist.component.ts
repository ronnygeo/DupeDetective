import { Component, OnInit } from '@angular/core';
import {Assignment} from "../../models/assignment";
import {AssignmentService} from "../../services/assignment.service";

/**
 * The Component that creates the Assignment List page
 */
@Component({
  selector: 'app-assignment-list',
  templateUrl: './assignmentlist.component.html',
  styleUrls: ['./assignmentlist.component.css']
})
export class AssignmentListComponent implements OnInit {

  private assignments;

  constructor(private assignmentService: AssignmentService) {}

  ngOnInit() {
    this.getAssignments();
  }

  getAssignments(): void {
    this.assignmentService.getAssignments().subscribe(assignments => {
      console.log(assignments);
      this.assignments = assignments;
    });
  }
}
