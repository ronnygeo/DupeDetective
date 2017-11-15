import { Injectable } from '@angular/core';
import {Assignment} from "./assignment";
import {Assignments} from "./mock-assignments";
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

@Injectable()
export class AssignmentService {

  constructor() { }

  getAssignments(): Observable<Assignment[]> {
    return of(Assignments);
  }

  getAssignment(id: number): Observable<Assignment> {
    return of(Assignments.find(assignment => assignment.id === id));
  }

}
