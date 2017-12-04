import { Component, OnInit } from '@angular/core';
import {AssignmentService} from "../../services/assignment.service";
import { Location } from '@angular/common';

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

  constructor(private assignmentService: AssignmentService,
              private location: Location) {}

  /**
   * On page load
   */
  ngOnInit() {
    this.getAssignments();
  }

  /**
   * Get assignments
   */
  getAssignments(): void {
    this.assignmentService.getAssignments().subscribe(assignments => {
      console.log(assignments);
      this.assignments = assignments;
    });
  }

  /**
   * Analyze assignment with given id
   * @param {string} id assignment id
   */
  analyze(id: string): void {
    console.log(id);
    this.assignmentService.analyze(id).subscribe(res => {
      console.log(res);
      location.reload();
    });
  }
}
