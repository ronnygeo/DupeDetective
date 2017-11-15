import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import {AssignmentListComponent} from './AssignmentList/assignmentlist.component';
import {UploadSubmissionComponent} from './UploadSubmission/uploadsubmission.component';
import {SubmissionListComponent} from './SubmissionList/submissionlist.component';
import {AssignmentService} from "./assignment.service";
import { AppRoutingModule } from './/app-routing.module';
import {RouterModule} from "@angular/router";
import {HomeComponent} from "./Home/home.component";
import {AssignmentDetailComponent} from "./AssignmentDetail/assignmentdetail.component";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
    AppComponent
    , HomeComponent
    , AssignmentListComponent
    , AssignmentDetailComponent
    , SubmissionListComponent
    // , UploadSubmissionComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [AssignmentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
