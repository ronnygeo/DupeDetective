import {Component, Input, OnInit} from '@angular/core';
import {DOC1} from "../../models/document1";
import {DOC2} from "../../models/document2";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-comparedocuments',
  templateUrl: './comparedocuments.component.html',
  styleUrls: ['./comparedocuments.component.css']
})
export class ComparedocumentsComponent implements OnInit {

  @Input() model;

  private doc1: string[];
  private doc2: string[];

  constructor(public activeModal: NgbActiveModal) { }

  ngOnInit() {
    console.log(this.model);
    this.doc1 = DOC1.split("\n");
    this.doc2 = DOC2.split("\n");
  }



}
