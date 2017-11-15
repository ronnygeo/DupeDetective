import { Injectable } from '@angular/core';
import {Assignment} from "./assignment";
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AssignmentService {

  private assignmentUrl = 'api/assignments';  // URL to web api

  constructor(private http: HttpClient) { }

  getAssignments(): Observable<Assignment[]> {
    return this.http.get<Assignment[]>(this.assignmentUrl)
      .pipe(
        catchError(this.handleError('getAssignments', []))
      );
  }

  /** GET assignment by id. Will 404 if id not found */
  getAssignment(id: number): Observable<Assignment> {
    const url = `${this.assignmentUrl}/${id}`;
    return this.http.get<Assignment>(url).pipe(
      tap(console.log),
      catchError(this.handleError<Assignment>(`getAssignment id=${id}`))
    );
  }

  /** Update an assignment **/
  updateAssignment (hero: Assignment): Observable<any> {
    return this.http.put(this.assignmentUrl, hero, httpOptions).pipe(
      catchError(this.handleError<any>('updateAssignment'))
    );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
