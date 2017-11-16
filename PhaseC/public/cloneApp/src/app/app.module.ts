import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import {AssignmentListComponent} from './AssignmentList/assignmentlist.component';
import {UploadSubmissionComponent} from './UploadSubmission/uploadsubmission.component';
import {SubmissionListComponent} from './SubmissionList/submissionlist.component';
import {AssignmentService} from "./assignment.service";
import { AppRoutingModule } from './/app-routing.module';
import {HomeComponent} from "./Home/home.component";
import {AssignmentDetailComponent} from "./AssignmentDetail/assignmentdetail.component";
import {HttpClientModule} from "@angular/common/http";
import {HttpClientInMemoryWebApiModule} from 'angular-in-memory-web-api';
import { InMemoryDataService }  from './in-memory-data.service';
import {AboutComponent} from "./About/about.component";


@NgModule({
  declarations: [
    AppComponent
    , HomeComponent
      , AboutComponent
    , AssignmentListComponent
    , AssignmentDetailComponent
    , SubmissionListComponent
    // , UploadSubmissionComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    // The HttpClientInMemoryWebApiModule module intercepts HTTP requests
    // and returns simulated server responses.
    // Remove it when a real server is ready to receive requests.
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, { dataEncapsulation: false }
    )
  ],
  providers: [AssignmentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
