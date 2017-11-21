import { BrowserModule } from '@angular/platform-browser';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import {AssignmentListComponent} from './components/assignmentlist/assignmentlist.component';
import {UploadSubmissionComponent} from './components/uploadsubmission/uploadsubmission.component';
import {SubmissionListComponent} from './components/submissionlist/submissionlist.component';
import {AssignmentService} from "./services/assignment.service";
import { AppRoutingModule } from './/app-routing.module';
import {HomeComponent} from "./components/home/home.component";
import {HttpClientModule} from "@angular/common/http";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {ReportComponent} from "./components/report/report.component";
import {ReportService} from "./services/report.service";
import {UserService} from "./services/user.service";
import {SubmissionService} from "./services/submission.service";
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import {AlertService} from "./services/alert.service";
import { ComparedocumentsComponent } from './components/comparedocuments/comparedocuments.component';
import {AssignmentNewComponent} from "./components/assignmentnew/assignmentnew.component";

@NgModule({
  declarations: [
    AppComponent
    , NavbarComponent
    , HomeComponent
    , AssignmentListComponent
    , AssignmentNewComponent
    , SubmissionListComponent
    , UploadSubmissionComponent
    , ReportComponent, NavbarComponent, LoginComponent, RegisterComponent, ComparedocumentsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NgbModule.forRoot(),
    AppRoutingModule,
    HttpClientModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [AssignmentService, ReportService, UserService, SubmissionService, AlertService],
  bootstrap: [AppComponent]
})
export class AppModule { }
