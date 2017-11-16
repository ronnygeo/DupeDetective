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
   * Is the current page home
   * @returns {boolean}
   */
  checkHome(): boolean {
    return (this.currentRt === "" || this.currentRt === "/" || this.currentRt === "/login" || this.currentRt === "/register");
  }

  isLoggedIn(): boolean {
    return false;
  }
}
