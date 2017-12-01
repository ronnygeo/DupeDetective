import { Component, OnInit, Input } from '@angular/core';
import {Assignment} from "../../models/assignment";
import {ActivatedRoute, Router} from '@angular/router';
import { Location } from '@angular/common';
import {AssignmentService} from "../../services/assignment.service";

/**
 * The Component that creates the Assignment Detail page
 */
@Component({
  selector: 'app-asignment-new',
  templateUrl: './assignmentnew.component.html',
  styleUrls: ['./assignmentnew.component.css']
})
export class AssignmentNewComponent implements OnInit {

  private name: string;
  private course: string;

  constructor(private router: Router,
              private assignmentService: AssignmentService,
              private location: Location) {}

  ngOnInit() {
  }

  save(): void {
    const data = {"name": this.name, "course": this.course, "isAnalyzed": false};
    this.assignmentService.createAssignment(data)
      .subscribe(() => this.goBack());
  }

  // Go back to previous page
  goBack(): void {
    this.location.back();
    // this.router.navigate(['/assignments']);
  }
}