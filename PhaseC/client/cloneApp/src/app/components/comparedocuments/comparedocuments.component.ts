import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {SubmissionService} from "../../services/submission.service";
import {ReportService} from "../../services/report.service";
import {UserService} from "../../services/user.service";
import {ReportLine} from "../../models/reportline";

/**
 * Compponent that creates the compare documents
 */
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

  /**
   * Get both student names
   */
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

  /**
   * Highlight lines in the code
   */
  highlightDocuments() {
    this.reportService.getReportByIds(this.refFileId, this.similarFileId).subscribe(report => {
      const lines = report.models.filter(m => m.model === this.modelId)[0].lines;

      // TODO: Refactor span check for already existing
      [this.doc1, this.doc2] = this.createSpanElements(lines, "ref", [this.doc1, this.doc2]);

      this.doc1 = this.doc1.replace(/\n/g, "<br>");
      this.doc2 = this.doc2.replace(/\n/g, "<br>");
    });
  }

  /**
   * Create span elements in the doc
   * @param lines
   * @param field
   * @param docArray
   * @returns {string[]}
   */
  createSpanElements(lines: ReportLine[], field: string, docArray: string[]) {
    let docs: string[] = [];
    for (let doc of docArray) {
      let docOffset = 0;
      for (const line of lines.sort( docArray.indexOf(doc) == 0? this.compareRefOffset: this.compareSimilarOffset)) {
        const substring = doc.substr(docOffset + line[field + "Offset"], line[field + "Length"]);
        if (substring.indexOf(this.openingTag) === -1 && substring.indexOf(this.closingTag) === -1) {
          doc = this.addTag(doc, docOffset, line[field + "Offset"], line[field + "Length"]);
          docOffset += this.tagLength;
        }
      }
      docs.push(doc);
    }
    return docs;
  }


  /**
   * Add tag
   * @param doc
   * @param docOffset
   * @param offset
   * @param length
   * @returns {any}
   */
  addTag(doc, docOffset, offset, length) {
    doc = this.insertTag(doc, this.openingTag, docOffset + offset);
    docOffset += this.openingTag.length;

    doc = this.insertTag(doc, this.closingTag, docOffset + offset + length);
    return doc;
  }

  /**
   * Insert tag
   * @param main_string
   * @param ins_string
   * @param pos
   * @returns {any}
   */
  insertTag(main_string, ins_string, pos) {
    if (typeof(pos) === "undefined") {
      pos = 0;
    }
    if (typeof(ins_string) === "undefined") {
      ins_string = '';
    }
    return main_string.slice(0, pos) + ins_string + main_string.slice(pos);
  }

  /**
   * Comparator for ref offset
   * @param {ReportLine} a
   * @param {ReportLine} b
   * @returns {number}
   */
  compareRefOffset(a: ReportLine, b: ReportLine): number {
      if (a.refOffset < b.refOffset) {
        return -1;
      }
      if (a.refOffset > b.refOffset) {
        return 1;
      }
      return 0;
  }

  /**
   * Comparator for similar offset
   * @param {ReportLine} a
   * @param {ReportLine} b
   * @returns {number}
   */
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
