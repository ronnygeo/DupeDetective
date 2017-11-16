import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {AssignmentListComponent} from "./components/AssignmentList/assignmentlist.component";
import {HomeComponent} from "./components/Home/home.component";
import {SubmissionListComponent} from "./components/SubmissionList/submissionlist.component";
import {AssignmentDetailComponent} from "./components/AssignmentDetail/assignmentdetail.component";
import {UploadSubmissionComponent} from "./components/UploadSubmission/uploadsubmission.component";

const routes: Routes = [
  { path: 'assignment/:assignmentId/submissions', component: SubmissionListComponent },
  { path: 'assignment/:assignmentId', component: AssignmentDetailComponent },
  { path: 'assignments', component: AssignmentListComponent },
  { path: 'submission/upload', component: UploadSubmissionComponent },
  { path: '', component: HomeComponent },
  { path: '', redirectTo: '', pathMatch: 'full' }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
