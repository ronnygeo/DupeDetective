import { Component, OnInit } from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";

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

  // TODO: Move to user service
  isLoggedIn(): boolean {
    return localStorage.getItem('currentUser') != null;
  }

  // TODO: Move to user service
  isGrader(): boolean {
    return true;
  }

  logout(): void {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.router.navigate(['/login']);
  }
}
