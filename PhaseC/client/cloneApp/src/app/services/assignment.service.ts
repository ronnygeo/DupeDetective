import { Injectable } from '@angular/core';
import {Assignment} from "../models/assignment";
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError} from 'rxjs/operators';
import {Submission} from "../models/submission";
import {AlertService} from "./alert.service";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

/**
 * Assignment Service that performs all communication related to assignment with the server
 */
@Injectable()
export class AssignmentService {

  private assignmentUrl = 'http://localhost:8080/api/assignments';  // URL to com.dupedetective.web api

  /**
   * Default Constructor
   * @param {HttpClient} http the http client service
   * @param {AlertService} alertService alert service
   */
  constructor(private http: HttpClient, private alertService: AlertService) { }

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
  getAssignment(id: string): Observable<Assignment> {
    const url = `${this.assignmentUrl}/${id}`;
    return this.http.get<Assignment>(url).pipe(
      catchError(this.handleError<Assignment>(`getAssignment id=${id}`))
    );
  }

  /**
   * Create an assignment
   * @param data object
   * @returns {Observable<Assignment>}
   */
  createAssignment (data): Observable<Assignment> {
    return this.http.post(this.assignmentUrl, data, httpOptions).pipe(
      catchError(this.handleError<any>('createAssignment'))
    );
  }

  /**
   * Analyze assignment with given id
   * @param {string} id
   * @returns {Observable<String>}
   */
  analyze(id: string): Observable<String> {
    return this.http.post(`${this.assignmentUrl}/${id}/analyze`, {}, httpOptions).pipe(
      catchError(this.handleError<any>('analyze'))
    );
  }

  /**
   * GET submissions for an assignment by id. Will 404 if id not found
   * @param {number} id the id of the assignment to retrieve
   * @returns {Observable<Submission[]>} an Observable for the Assignments
   */
  getSubmissionsByAssignmentId(id: string): Observable<Submission[]> {
    const url = `${this.assignmentUrl}/${id}/submissions`;
    return this.http.get<Submission[]>(url).pipe(
      catchError(this.handleError<Submission[]>(`getSubmission id=${id}`))
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
      this.alertService.error(error.message);
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
