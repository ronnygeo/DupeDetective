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
  private isHome = true;

  constructor(private router: Router) { }

  /**
   * On page load
   */
  ngOnInit() {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.currentRt = event.url;
        this.isHomePage();
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
    return !!(tmp && !isUndefined(tmp) && JSON.parse(tmp)["grader"] === true);
  }

  /**
   * Fn to check if current route is home
   */
  isHomePage(): void {
    this.isHome = this.router.url == "/";
  }

  /**
   * Logout from the site
   */
  logout(): void {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.router.navigate(['/']);
  }
}
