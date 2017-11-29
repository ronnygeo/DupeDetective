import { Injectable } from '@angular/core';
import {Assignment} from "../models/assignment";
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import {User} from "../models/user";
import {filter} from "rxjs/operator/filter";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

/**
 * User Service that performs all communication related to users with the server
 */
@Injectable()
export class UserService {

  private userUrl = 'http://localhost:8080/api/users';

  constructor(private http: HttpClient) { }

  /**
   *
   * @returns {Observable<User[]>}
   */
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl)
      .pipe(
        // map(r => r["_embedded"]["users"]),
        catchError(this.handleError('getAssignments', []))
      );
  }

  /**
   *
   * @param {string} username
   * @param {string} password
   * @returns {Observable<User[]>}
   */
  getUser(username: string, password: string): Observable<User> {
    const url = `${this.userUrl}/${username}/${password}`;
    return this.http.get<User>(url).pipe(
      // map(r => r["_embedded"]["users"]),
      catchError(this.handleError<User>(`getUser user=${username}`))
    );
  }

  /** Create a new user
   * @param data json object
   * @returns {Observable<User>} a user observable
   * */
  createUser (data): Observable<User> {
    return this.http.post(this.userUrl, data, httpOptions).pipe(
      catchError(this.handleError<any>('updateUser'))
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
