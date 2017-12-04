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
      this.submissionService.getSubmission(this.similarFileId).subscribe(submission => {
        this.doc2 = submission.filecontent;
        this.highlightDocuments();
      });
    });
  }

  /**
   * Highlight lines in the code
   */
  highlightDocuments() {
    this.reportService.getReportByIds(this.refFileId, this.similarFileId).subscribe(report => {
      const lines = report.models.filter(m => m.model === this.modelId)[0].lines;

      this.filterLines(lines, l => l.refOffset, l => l.refLength);
      this.filterLines(lines, l => l.similarOffset, l => l.similarLength);
      this.doc1 = this.createSpanElements(lines, this.doc1, l => l.refOffset, l => l.refLength);
      this.doc2 = this.createSpanElements(lines, this.doc2, l => l.similarOffset, l => l.similarLength);

      this.doc1 = this.doc1.replace(/\n/g, "<br>");
      this.doc2 = this.doc2.replace(/\n/g, "<br>");
    });
  }

  /**
   *  Filter the lines in report, so that they don't overlap
   * @param {ReportLine[]} lines
   * @param {(_) => any} fnOffset function to access the offset field
   * @param {(_) => any} fnLength function to access the length field
   */
  filterLines(lines: ReportLine[], fnOffset = _ => _, fnLength = _ => _) {
    let sortLines = lines.sort((a, b) => {
      const offseta = fnOffset(a);
      const offsetb = fnOffset(b);
      if (offseta ==  offsetb && fnLength(a) == fnLength(b)) return 0;
      if (offseta ==  offsetb && fnLength(a) < fnLength(b)) return 1;
      if (offseta ==  offsetb && fnLength(a) > fnLength(b)) return -1;
      if (offseta <  offsetb) return -1;
      if (offseta >  offsetb) return 1;
    });

    this.removeDuplicateLines(sortLines, fnOffset, fnLength);
  }

  /**
   * Remove any duplicate offsets
   * @param {ReportLine[]} arr Report Lines
   * @param {(_) => any} fnOffset function to access the offset field
   * @param {(_) => any} fnLength function to access the length field
   * @returns {ReportLine[] | undefined} Report Lines with duplicates removed
   */
  removeDuplicateLines(arr: ReportLine[] = [], fnOffset = _ => _, fnLength = _ => _) {
    const set = new Set();
    let len = arr.length;

    for (let i = 0; i < len; i++) {
      const offset = fnOffset(arr[i]);
      const length = fnLength(arr[i]);
      if (set.has(offset)) {
        arr.splice(i, 1);
        i--;
        len--;
      } else {
        set.add(offset);
      }
    }

    const offsets = arr.map(l => fnOffset(l) + fnLength(l));
    for (let i = 0; i < arr.length; i++) {
      if (arr[i].refOffset in offsets) {
        arr.splice(i, 1);
        i--;
        len--;
      }
    }
  }

  /**
   * Create span element
   * @param {ReportLine[]} lines Report Lines
   * @param {string} doc document
   * @param {(_) => any} fnOffset function to access the offset field
   * @param {(_) => any} fnLength function to access the length field
   * @returns {string} new document
   */
  createSpanElements(lines: ReportLine[], doc: string, fnOffset = _ => _, fnLength = _ => _) {
      let docOffset = 0;
      for (const line of lines) {
          const substring = doc.substr(docOffset + fnOffset(line), fnLength(line));
          console.log(substring.search("s?pan?"));
          if (substring.indexOf(this.openingTag) === -1 && substring.indexOf(this.closingTag) === -1 && substring.search("s?pan?>?") === -1) {
            doc = this.addTag(doc, docOffset, fnOffset(line), fnLength(line));
            docOffset += this.tagLength;
          }
      }
    return doc;
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
}
