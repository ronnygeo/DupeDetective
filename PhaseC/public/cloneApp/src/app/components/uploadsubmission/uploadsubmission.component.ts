import { Component, OnInit } from '@angular/core';
import {SubmissionService} from "../../services/submission.service";
import {AssignmentService} from "../../services/assignment.service";
import {Assignment} from "../../models/assignment";
import { Location } from '@angular/common';


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
              private location: Location) {
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

  readThis(inputValue: any): void {
    const file: File = inputValue.files[0];
    this.filename = inputValue.files[0].name;
    const myReader: FileReader = new FileReader();

    myReader.onloadend = (e) => {
      this.fileContent = myReader.result;
    };
    myReader.readAsText(file);

  }

  upload() {
    if (this.fileContent != null || this.filename != null || this.assignmentId != null || this.userId != null) {
      this.submissionService.uploadSubmission({"filename": this.filename, "filecontent": this.fileContent,
        "assignmentId": this.assignmentId, "studentId": this.userId, "submittedOn": new Date().toJSON(), "checksum": "4ghvg77"}).subscribe(
        data => {
          console.log('success');
          location.reload();
        }
      );
    }
  }
}
