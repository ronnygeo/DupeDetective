import { Component, OnInit } from '@angular/core';
import {Assignment} from "../assignment";
import {AssignmentService} from "../assignment.service";

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
    this.assignmentService.getAssignments().subscribe(assignments => this.assignments = assignments);
  }
}
