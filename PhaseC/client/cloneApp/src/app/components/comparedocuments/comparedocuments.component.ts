import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {SubmissionService} from "../../services/submission.service";
import {ReportService} from "../../services/report.service";
import {UserService} from "../../services/user.service";
import {Report} from "../../models/report";
import {ReportLine} from "../../models/reportline";

@Component({
  selector: 'app-comparedocuments',
  templateUrl: './comparedocuments.component.html',
  styleUrls: ['./comparedocuments.component.css']
})
export class ComparedocumentsComponent implements OnInit {

  @Input() model;
  @Input() refFileId;
  @Input() similarFileId;
  @Input() student1;
  @Input() student2;

  private doc1: string;
  private doc2: string;
  private studentname1: string;
  private studentname2: string;
  private lines: ReportLine[];
  private modelId: number;

  private openingTag = "<span class='highlight-similar'>";
  private closingTag = "</span>";
  private tagLength = this.openingTag.length + this.closingTag.length;

  constructor(public activeModal: NgbActiveModal,
              private submissionService: SubmissionService,
              private reportService: ReportService,
              private userService: UserService) { }

  /**
   * On page load
   */
  ngOnInit() {
    this.getStudentNames();
    this.getDocuments();
    switch(this.model) {
      case "structure": this.modelId = 1; break;
      case "loop": this.modelId = 2; break;
      case "method": this.modelId = 3; break;
      case "winnowing": this.modelId = 5; break;
    }
    this.highlightDocuments();
  }

  getStudentNames() {
    this.userService.getUserById(this.student1).subscribe(student => this.studentname1 = student.name);
    this.userService.getUserById(this.student2).subscribe(student => this.studentname2 = student.name);
  }

  /**
   * Get both the documents
   */
  getDocuments() {
    this.submissionService.getSubmission(this.refFileId).subscribe(submission => {
      this.doc1 = submission.filecontent;
    });
    this.submissionService.getSubmission(this.similarFileId).subscribe(submission => {
      this.doc2 = submission.filecontent;
    });
  }

  highlightDocuments() {
    this.reportService.getReportByIds(this.refFileId, this.similarFileId).subscribe(report => {
      const lines = report.models.filter(m => m.model === this.modelId)[0].lines;

      let doc1Offset = 0;
      let doc2Offset = 0;

      // TODO: Refactor span check for already existing
      console.log(lines.sort(this.compareRefOffset));
      for (const line of lines.sort(this.compareRefOffset)) {
        const substring = this.doc1.substr(doc1Offset + line.refOffset, line.refLength);
        if (substring.indexOf(this.closingTag) === -1 && substring.indexOf(this.closingTag) === -1 && substring.indexOf("</") === -1 &&
          substring.indexOf("</s") === -1
        ) {
          console.log(this.doc1.substr(doc1Offset + line.refOffset, line.refLength));
        this.doc1 = this.addTag(this.doc1, doc1Offset, line.refOffset, line.refLength);
        doc1Offset += this.tagLength;
        }
      }

      for (const line of lines.sort(this.compareSimilarOffset)) {
        this.doc2 = this.addTag(this.doc2, doc2Offset, line.similarOffset, line.similarLength);
        doc2Offset += this.tagLength;
      }

      this.doc1 = this.doc1.replace(/\n/g, "<br>");
      this.doc2 = this.doc2.replace(/\n/g, "<br>");
    });
  }

  addTag(doc, docOffset, offset, length) {
    doc = this.insertTag(doc, this.openingTag, docOffset + offset);
    docOffset += this.openingTag.length;

    doc = this.insertTag(doc, this.closingTag, docOffset + offset + length);
    return doc;
  }

  insertTag(main_string, ins_string, pos) {
    if (typeof(pos) === "undefined") {
      pos = 0;
    }
    if (typeof(ins_string) === "undefined") {
      ins_string = '';
    }
    return main_string.slice(0, pos) + ins_string + main_string.slice(pos);
  }

  compareRefOffset(a: ReportLine, b: ReportLine): number {
      if (a.refOffset < b.refOffset) {
        return -1;
      }
      if (a.refOffset > b.refOffset) {
        return 1;
      }
      return 0;
  }

  compareSimilarOffset(a: ReportLine, b: ReportLine): number {
    if (a.similarOffset < b.similarOffset) {
      return -1;
    }
    if (a.similarOffset > b.similarOffset) {
      return 1;
    }
    return 0;
  }


}
