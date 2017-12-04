import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Submission} from "../../models/submission";
import {SubmissionService} from "../../services/submission.service";
import {AssignmentService} from "../../services/assignment.service";
import {UserService} from "../../services/user.service";

/**
 * List all Submissions
 */
@Component({
  selector: 'app-submission-list',
  templateUrl: './submissionlist.component.html',
  styleUrls: ['./submissionlist.component.css']
})
export class SubmissionListComponent implements OnInit {

  private submissions: Submission[];
  private users = {};
  private assignments = {};

  constructor(private route: ActivatedRoute,
              private submissionService: SubmissionService,
              private assignmentService: AssignmentService,
              private userService: UserService) {
  }

  /**
   * On page load
   */
  ngOnInit() {
    this.getSubmissions();
  }

  /**
   * Get all submissions
   */
  getSubmissions(): void {
    if (this.route.snapshot.paramMap.get('assignmentId') != null && this.route.snapshot.paramMap.get('assignmentId') !== "") {
      const id: string = this.route.snapshot.paramMap.get('assignmentId');
      console.log(id);
      this.assignmentService.getSubmissionsByAssignmentId(id)
        .subscribe(submissions => {
          this.submissions = submissions;
          this.getUsers();
          this.getAssignments();
        });
    } else {
      this.submissionService.getAllSubmissions()
        .subscribe(submissions => {
          this.submissions = submissions;
          this.getUsers();
          this.getAssignments();
        });
    }
  }

  /**
   * Get users of submissions
   */
  getUsers(): void {
    for (let submission of this.submissions) {
      this.userService.getUserById(submission.studentId).subscribe(u => {
        this.users[submission.id] = u.name;
      });
    }
  }

  /**
   * Get assignment of submissions
   */
  getAssignments(): void {
    for (let submission of this.submissions) {
      this.assignmentService.getAssignment(submission.assignmentId).subscribe(a => {
        this.assignments[submission.id] = a.name;
      });
    }
  }
}
