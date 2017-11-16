import { Component, OnInit } from '@angular/core';
import {FileService} from "../../services/file.service";

@Component({
  selector: 'app-upload-submission',
  templateUrl: './uploadsubmission.component.html',
  styleUrls: ['./uploadsubmission.component.css']

})
export class UploadSubmissionComponent implements OnInit {

  private fileList: FileList;

  constructor(private fileService: FileService) {
  }

  ngOnInit() {
  }

  fileChange(event): void {
    this.fileList = event.target.files;
  }

  upload() {
    if (this.fileList.length > 0) {
      this.fileService.upload(this.fileList[0]).subscribe(
        data => console.log('success'),
        error => console.log(error)
      );
    }
  }
}
