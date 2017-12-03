import { Injectable } from '@angular/core';
import {Assignment} from "../models/assignment";
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import {Submission} from "../models/submission";
import {filter} from "rxjs/operator/filter";
import {Report} from "../models/report";

const httpOptions = {
  headers: new HttpHeaders(
    { 'Content-Type': 'application/json',
     'Authorization': 'Bearer ' + 'eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9....'}
    )
};

/**
 * Submission Service that performs all communication related to submissions with the server
 */
@Injectable()
export class SubmissionService {

  private submissionUrl = 'http://localhost:8080/api/submissions';  // URL to web api

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
  getSubmission(id: string): Observable<Submission> {
    const url = `${this.submissionUrl}/${id}`;
    return this.http.get<Submission>(url).pipe(
      catchError(this.handleError<Submission>(`getSubmission id=${id}`))
    );
  }

  /**
   * GET submissions for an assignment by id. Will 404 if id not found
   * @param {number} id the id of the assignment to retrieve
   * @returns {Observable<Assignment>} an Observable for the Assignments
   */
  getSubmissions(id: string): Observable<Submission[]> {
    const url = `${this.submissionUrl}?assignmentId=${id}`;
    return this.http.get<Submission[]>(url).pipe(
      catchError(this.handleError<Submission[]>(`getSubmission id=${id}`))
    );
  }

  /**
   *
   * @param {string} assignmentId
   * @param {string} studentId
   * @returns {Observable<Submission>}
   */
  getSubmissionByStudentAssignment(assignmentId: string, studentId: string): Observable<Submission> {
    const url = `${this.submissionUrl}/student?assignmentId=${assignmentId}&studentId=${studentId}`;
    return this.http.get<Submission>(url).pipe(
      catchError(this.handleError<Submission>(`getSubmission assignmentId=${assignmentId} studentId=${studentId}`))
    );
  }

  /**
   * Upload the given submission to server
   * @param data form data
   * @returns {Observable<any | any>}
   */
  uploadSubmission(data) {
    // It is very important to leave the Content-Type empty
    // do not use headers.append('Content-Type', 'multipart/form-data');
    return this.http.post(`${this.submissionUrl}`, JSON.stringify(data), httpOptions)
      .pipe(
        catchError(this.handleError<any>('uploadSubmission'))
      );
  }

    /**
     * GET report by assignment, ref file, similar file id. Will 404 if id not found
     * @param {string} submissionId
     * @returns {Observable<Report[]>}
     */
    getReportsBySubmissionId(submissionId: string): Observable<Report[]> {
      const url = `${this.submissionUrl}/${submissionId}/reports`;
      return this.http.get<Report[]>(url)
        .pipe(
        catchError(this.handleError<Report[]>(`getReport submissionId=${submissionId}`))
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

      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
