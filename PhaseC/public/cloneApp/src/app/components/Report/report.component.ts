import { Component, OnInit, Input } from '@angular/core';
import {Assignment} from "../../models/assignment";
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import {ReportService} from "../../services/report.service";

/**
 * The Component that creates the Report page
 */
@Component({
  selector: 'app-submission-list',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  private assignment: Assignment;

  constructor(private route: ActivatedRoute,
              private reportService: ReportService,
              private location: Location) {}

  ngOnInit() {
    this.getAssignment();
  }

  // Get the assignment
  getAssignment(): void {
    const id = +this.route.snapshot.paramMap.get('assignmentId');
    this.reportService.getAssignment(id)
      .subscribe(assignment => this.assignment = assignment);
  }

  save(): void {
    this.reportService.updateAssignment(this.assignment)
      .subscribe(() => this.goBack());
  }

  // Go back to previous page
  goBack(): void {
    this.location.back();
  }
}
