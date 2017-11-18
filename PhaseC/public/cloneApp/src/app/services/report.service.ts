import { Injectable } from '@angular/core';
import {Assignment} from "../models/assignment";
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

/**
 * Report Service that performs all communication related to reports with the server
 */
@Injectable()
export class ReportService {

  private assignmentUrl = 'api/reports';  // URL to web api

  /**
   * Default Constructor
   * @param {HttpClient} http the http client service
   */
  constructor(private http: HttpClient) { }

  /**
   * Get all the assignments
   * @returns {Observable<Assignment[]>} an Observable for the array of Assignments
   */
  getAssignments(): Observable<Assignment[]> {
    return this.http.get<Assignment[]>(this.assignmentUrl)
      .pipe(
        catchError(this.handleError('getAssignments', []))
      );
  }

  /**
   * GET assignment by id. Will 404 if id not found
   * @param {number} id the id of the assignment to retrieve
   * @returns {Observable<Assignment>} an Observable for the Assignments
   */
  getAssignment(id: number): Observable<Assignment> {
    const url = `${this.assignmentUrl}/${id}`;
    return this.http.get<Assignment>(url).pipe(
      tap(console.log),
      catchError(this.handleError<Assignment>(`getAssignment id=${id}`))
    );
  }

  /**
   * Update an assignment
   * @param {Assignment} assignment
   * @returns {Observable<any>}
   */
  updateAssignment (assignment: Assignment): Observable<any> {
    return this.http.put(this.assignmentUrl, assignment, httpOptions).pipe(
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
