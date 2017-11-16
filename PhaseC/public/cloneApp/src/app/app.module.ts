import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import {AssignmentListComponent} from './components/AssignmentList/assignmentlist.component';
import {UploadSubmissionComponent} from './components/UploadSubmission/uploadsubmission.component';
import {SubmissionListComponent} from './components/SubmissionList/submissionlist.component';
import {AssignmentService} from "./services/assignment.service";
import { AppRoutingModule } from './/app-routing.module';
import {HomeComponent} from "./components/Home/home.component";
import {AssignmentDetailComponent} from "./components/AssignmentDetail/assignmentdetail.component";
import {HttpClientModule} from "@angular/common/http";
import {HttpClientInMemoryWebApiModule} from 'angular-in-memory-web-api';
import { InMemoryDataService } from './services/in-memory-data.service';
import {AboutComponent} from "./components/About/about.component";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FileService} from "./services/file.service";
import {ReportComponent} from "./components/Report/report.component";
import {ReportService} from "./services/report.service";
import {UserService} from "./services/user.service";
import {SubmissionService} from "./services/submission.service";

@NgModule({
  declarations: [
    AppComponent
    , HomeComponent
      , AboutComponent
    , AssignmentListComponent
    , AssignmentDetailComponent
    , SubmissionListComponent
    , UploadSubmissionComponent
    , ReportComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NgbModule.forRoot(),
    AppRoutingModule,
    HttpClientModule,
    // The HttpClientInMemoryWebApiModule module intercepts HTTP requests
    // and returns simulated server responses.
    // Remove it when a real server is ready to receive requests.
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, { dataEncapsulation: false }
    )
  ],
  providers: [AssignmentService, FileService, ReportService, UserService, SubmissionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
