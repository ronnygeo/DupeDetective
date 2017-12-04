import { Injectable } from '@angular/core';
import { Router, NavigationStart } from '@angular/router';
import { Subject } from 'rxjs/Subject';
import {Observable} from "rxjs/Observable";

/**
 * Handle Alerts
 */
@Injectable()
export class AlertService {
  private subject = new Subject<any>();
  private keepAfterNavigationChange = false;

  /**
   * On load
   * @param {Router} router
   */
  constructor(private router: Router) {
    // clear alert message on route change
    router.events.subscribe(event => {
      if (event instanceof NavigationStart) {
        if (this.keepAfterNavigationChange) {
          // only keep for a single location change
          this.keepAfterNavigationChange = false;
        } else {
          // clear alert
          this.subject.next();
        }
      }
    });
  }

  /**
   * If success
   * @param {string} message
   * @param {boolean} keepAfterNavigationChange
   */
  success(message: string, keepAfterNavigationChange = false) {
    this.keepAfterNavigationChange = keepAfterNavigationChange;
    this.subject.next({ type: 'success', text: message });
  }

  /**
   * If error
   * @param {string} message
   * @param {boolean} keepAfterNavigationChange
   */
  error(message: string, keepAfterNavigationChange = false) {
    this.keepAfterNavigationChange = keepAfterNavigationChange;
    this.subject.next({ type: 'error', text: message });
  }

  /**
   * Get the message
   * @returns {Observable<any>}
   */
  getMessage(): Observable<any> {
    return this.subject.asObservable();
  }
}
