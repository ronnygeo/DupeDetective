import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {AssignmentListComponent} from "./components/assignmentlist/assignmentlist.component";
import {HomeComponent} from "./components/home/home.component";
import {SubmissionListComponent} from "./components/submissionlist/submissionlist.component";
import {UploadSubmissionComponent} from "./components/uploadsubmission/uploadsubmission.component";
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {ReportComponent} from "./components/report/report.component";
import {AssignmentNewComponent} from "./components/assignmentnew/assignmentnew.component";
import {ComparedocumentsComponent} from "./components/comparedocuments/comparedocuments.component";
import {AuthGuardGrader, AuthGuardStudent} from "./auth.guard";

// Defining routes
const routes: Routes = [
  { path: 'assignments', component: AssignmentListComponent, canActivate: [AuthGuardGrader] },
  { path: 'assignments/new', component: AssignmentNewComponent, canActivate: [AuthGuardGrader] },
  { path: 'assignment/:assignmentId/submissions', component: SubmissionListComponent, canActivate: [AuthGuardGrader] },
  { path: 'submissions', component: SubmissionListComponent, canActivate: [AuthGuardGrader] },
  { path: 'compare', component: ComparedocumentsComponent, canActivate: [AuthGuardGrader] },
  { path: 'reports', component: ReportComponent, canActivate: [AuthGuardGrader] },
  { path: 'assignment/:assignmentId/submission/:submissionId/reports', component: ReportComponent, canActivate: [AuthGuardGrader] },
  { path: 'submission/:assignmentId', component: SubmissionListComponent, canActivate: [AuthGuardGrader] },
  { path: 'submissions/new', component: UploadSubmissionComponent, canActivate: [AuthGuardStudent] },
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
