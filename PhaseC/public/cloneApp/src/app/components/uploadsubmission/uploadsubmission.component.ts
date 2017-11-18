import { Component, OnInit } from '@angular/core';
import {FileService} from "../../services/file.service";

@Component({
  selector: 'app-upload-submission',
  templateUrl: './uploadsubmission.component.html',
  styleUrls: ['./uploadsubmission.component.css']

})
export class UploadSubmissionComponent implements OnInit {

  private fileContent: string;
  private filename: string;
  private assignmentId: number;
  private userId: number;

  constructor(private fileService: FileService) {
  }

  ngOnInit() {
  }

  // fileChange(event): void {
  //   this.fileList = event.target.files;
  // }

  fileChange($event): void {
    this.readThis($event.target);
  }

  readThis(inputValue: any): void {
    const file: File = inputValue.files[0];
    const myReader: FileReader = new FileReader();

    myReader.onloadend = (e) => {
      this.fileContent = myReader.result;
    };
    myReader.readAsText(file);

  }

  upload() {
    if (this.fileContent != null || this.filename != null) {
      // this.fileService.upload().subscribe(
      //   data => console.log('success'),
      //   error => console.log(error)
      // );
    }
  }
}
