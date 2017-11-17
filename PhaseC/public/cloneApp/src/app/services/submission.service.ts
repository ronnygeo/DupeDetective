import { Injectable } from '@angular/core';
import {Assignment} from "../models/assignment";
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import {Submission} from "../models/submission";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

/**
 * Submission Service that performs all communication related to submissions with the server
 */
@Injectable()
export class SubmissionService {

  private submissionUrl = 'api/submissions';  // URL to web api

  /**
   * Default Constructor
   * @param {HttpClient} http the http client service
   */
  constructor(private http: HttpClient) { }

  /**
   * Get all the submissions
   * @returns {Observable<Submission[]>} an Observable for the array of Assignments
   */
  getAllSubmissions(): Observable<Submission[]> {
    return this.http.get<Submission[]>(this.submissionUrl)
      .pipe(
        catchError(this.handleError('getAllSubmissions', []))
      );
  }

  /**
   * GET submissions for an assignment by id. Will 404 if id not found
   * @param {number} id the id of the assignment to retrieve
   * @returns {Observable<Assignment>} an Observable for the Assignments
   */
  getSubmissions(id: number): Observable<Submission[]> {
    const url = `${this.submissionUrl}/${id}`;
    return this.http.get<Submission[]>(url).pipe(
      tap(console.log),
      catchError(this.handleError<Submission[]>(`getSubmission id=${id}`))
    );
  }

  /**
   * Update an assignment
   * @param {Submission} submission
   * @returns {Observable<any>}
   */
  updateAssignment (submission: Submission): Observable<any> {
    return this.http.put(this.submissionUrl, submission, httpOptions).pipe(
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
