import { Component, OnInit } from '@angular/core';
import {SubmissionService} from "../../services/submission.service";
import {AssignmentService} from "../../services/assignment.service";
import {Assignment} from "../../models/assignment";
import { Location } from '@angular/common';
import {AlertService} from "../../services/alert.service";


/**
 * Upload submission component
 */
@Component({
  selector: 'app-upload-submission',
  templateUrl: './uploadsubmission.component.html',
  styleUrls: ['./uploadsubmission.component.css']

})
export class UploadSubmissionComponent implements OnInit {

  private fileContent: string;
  private filename: string;
  private assignmentId: string;
  private userId: string;
  private assignments: Assignment[];

  constructor(private submissionService: SubmissionService,
              private assignmentService: AssignmentService,
              private location: Location,
              private alertService: AlertService) {
  }

  /**
   * On page load
   */
  ngOnInit() {
    this.userId = JSON.parse(localStorage.getItem('currentUser'))["id"];
    this.assignmentService.getAssignments().subscribe(assignments => {
      this.assignments = assignments;
      this.assignmentId = assignments && assignments.length > 0 ? this.assignments[0].id : null;
    });
  }

  /**
   * on file change read it tt
   * @param $event
   */
  fileChange($event): void {
    this.readThis($event.target);
  }

  /**
   * Read the file contents
   * @param inputValue list of files
   */
  readThis(inputValue: any): void {
    const file: File = inputValue.files[0];
    this.filename = inputValue.files[0].name;
    const myReader: FileReader = new FileReader();

    myReader.onloadend = (e) => {
      this.fileContent = myReader.result;
    };
    myReader.readAsText(file);

  }

  /**
   * Upload the submission
   */
  upload() {
    if (this.fileContent != null || this.filename != null || this.assignmentId != null || this.userId != null) {
      this.submissionService.uploadSubmission({"filename": this.filename, "filecontent": this.fileContent,
        "assignmentId": this.assignmentId, "studentId": this.userId, "submittedOn": new Date().toJSON(), "checksum": "4ghvg77"}).subscribe(
        data => {
          this.alertService.success("Upload successful.");
          location.reload();
        }
      );
    }
  }
}
