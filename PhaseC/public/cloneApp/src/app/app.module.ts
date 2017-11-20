import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import {AssignmentListComponent} from './components/assignmentlist/assignmentlist.component';
import {UploadSubmissionComponent} from './components/uploadsubmission/uploadsubmission.component';
import {SubmissionListComponent} from './components/submissionlist/submissionlist.component';
import {AssignmentService} from "./services/assignment.service";
import { AppRoutingModule } from './/app-routing.module';
import {HomeComponent} from "./components/home/home.component";
import {AssignmentDetailComponent} from "./components/assignmentdetail/assignmentdetail.component";
import {HttpClientModule} from "@angular/common/http";
import {HttpClientInMemoryWebApiModule} from 'angular-in-memory-web-api';
import { InMemoryDataService } from './services/in-memory-data.service';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FileService} from "./services/file.service";
import {ReportComponent} from "./components/report/report.component";
import {ReportService} from "./services/report.service";
import {UserService} from "./services/user.service";
import {SubmissionService} from "./services/submission.service";
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import {AlertService} from "./services/alert.service";
import { ComparedocumentsComponent } from './components/comparedocuments/comparedocuments.component';

@NgModule({
  declarations: [
    AppComponent
    , NavbarComponent
    , HomeComponent
    , AssignmentListComponent
    , AssignmentDetailComponent
    , SubmissionListComponent
    , UploadSubmissionComponent
    , ReportComponent, NavbarComponent, LoginComponent, RegisterComponent, ComparedocumentsComponent
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
  providers: [AssignmentService, FileService, ReportService, UserService, SubmissionService, AlertService],
  bootstrap: [AppComponent]
})
export class AppModule { }
