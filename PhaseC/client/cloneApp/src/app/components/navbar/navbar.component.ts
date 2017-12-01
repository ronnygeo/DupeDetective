import { Component, OnInit } from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";
import {isUndefined} from "util";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})

/**
 * Component that creates the nav bar
 */
export class NavbarComponent implements OnInit {

  private currentRt;
  private isCollapsed = true;

  constructor(private router: Router) { }

  /**
   * On page load
   */
  ngOnInit() {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        console.log("Current Route: " + event.url);
        this.currentRt = event.url;
      }
    });

  }

  /**
   * Fn to check if user loggedin
   * @returns {boolean} true or false
   */
  isLoggedIn(): boolean {
    return localStorage.getItem('currentUser') != null;
  }

  /**
   * Fn to check if user is grader
   * @returns {boolean} true or false
   */
  isGrader(): boolean {
    const tmp = localStorage.getItem("currentUser");
    if (tmp && !isUndefined(tmp) && JSON.parse(tmp)["grader"] === true) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Logout from the site
   */
  logout(): void {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.router.navigate(['/login']);
  }
}
