import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {AssignmentListComponent} from "./AssignmentList/assignmentlist.component";
import {HomeComponent} from "./Home/home.component";
import {SubmissionListComponent} from "./SubmissionList/submissionlist.component";
import {AssignmentDetailComponent} from "./AssignmentDetail/assignmentdetail.component";
import {AboutComponent} from "./About/about.component";

const routes: Routes = [
  { path: 'assignment/:assignmentId/submissions', component: SubmissionListComponent },
  { path: 'assignment/:assignmentId', component: AssignmentDetailComponent },
  { path: 'assignments', component: AssignmentListComponent },
  { path: '', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: '', redirectTo: '', pathMatch: 'full' }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
