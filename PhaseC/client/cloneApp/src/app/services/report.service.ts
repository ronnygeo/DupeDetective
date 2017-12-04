import { Injectable } from '@angular/core';
import {Assignment} from "../models/assignment";
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import {Report} from "../models/report";
import {assign} from "rxjs/util/assign";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

/**
 * ModelReport Service that performs all communication related to reports with the server
 */
@Injectable()
export class ReportService {

  private reportUrl = 'http://localhost:8080/api/reports';  // URL to com.dupedetective.web api

  /**
   * Default Constructor
   * @param {HttpClient} http the http client service
   */
  constructor(private http: HttpClient) { }

  /**
   * Get all the reports
   * @returns {Observable<Report[]>} an Observable for the array of Reports
   */
  getAllReports(): Observable<Report[]> {
    return this.http.get<Report[]>(this.reportUrl)
      .pipe(
        catchError(this.handleError('getReport', []))
      );
  }

  /**
   * GET report by id. Will 404 if id not found
   * @param {number} id the id of the report to retrieve
   * @returns {Observable<Report>} an Observable for the Report
   */
  getReport(id: string): Observable<Report> {
    const url = `${this.reportUrl}/${id}`;
    return this.http.get<Report>(url).pipe(
      catchError(this.handleError<Report>(`getReport id=${id}`))
    );
  }

  /**
   * GET report by assignment, ref file, similar file id. Will 404 if id not found
   * @param {string} refFileId
   * @param {string} similarFileId
   * @returns {Observable<Report[]>}
   */
  getReportByIds(refFileId: string, similarFileId: string): Observable<Report> {
    const url = `${this.reportUrl}/single?refFileId=${refFileId}&similarFileId=${similarFileId}`;
    return this.http.get<Report>(url).pipe(
      catchError(this.handleError<Report>(`getReport refFileId=${refFileId} similarFileId=${similarFileId}`))
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
