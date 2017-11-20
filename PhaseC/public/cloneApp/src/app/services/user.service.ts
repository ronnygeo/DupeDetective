import { Injectable } from '@angular/core';
import {Assignment} from "../models/assignment";
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import {User} from "../models/user";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

/**
 * User Service that performs all communication related to users with the server
 */
@Injectable()
export class UserService {

  private userUrl = 'api/users';

  constructor(private http: HttpClient) { }

  /**
   *
   * @returns {Observable<User[]>}
   */
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl)
      .pipe(
        catchError(this.handleError('getAssignments', []))
      );
  }

  /**
   *
   * @param {string} username
   * @param {string} password
   * @returns {Observable<User>}
   */
  getUser(username: string, password: string): Observable<User> {
    const url = `${this.userUrl}?username=${username}&password=${password}`;
    return this.http.get<User>(url).pipe(
      catchError(this.handleError<User>(`getUser user=${username}`))
    );
  }

  /** Update an assignment **/
  updateUser (user: User): Observable<any> {
    return this.http.put(this.userUrl, user, httpOptions).pipe(
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
