import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { catchError } from 'rxjs/operators';

/**
 * File Service that performs all communication related to files with the server
 */
@Injectable()
export class FileService {

  private fileUrl = 'api/files';  // URL to web api

  /**
   * Default constructor
   * @param {HttpClient} http http client provider
   */
  constructor(private http: HttpClient) { }

  /**
   * Upload the given file to server
   * @param file
   * @returns {Observable<any | any>}
   */
  upload(file) {
    const formData = new FormData();
    formData.set('id',  "1");
    formData.append('file', file, file.name);

    // It is very important to leave the Content-Type empty
    // do not use headers.append('Content-Type', 'multipart/form-data');
    const httpOptions = {
      headers: new HttpHeaders({ 'Authorization': 'Bearer ' + 'eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9....' })
    };

    return this.http.post(this.fileUrl, formData, httpOptions)
      .pipe(
        catchError(this.handleError<any>('uploadAssignment'))
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
