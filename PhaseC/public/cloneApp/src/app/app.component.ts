import {Component, OnInit} from '@angular/core';
import {Event, NavigationEnd, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Dupe Detective';

  private currentRoute;

  constructor(private router: Router) { }

  /**
   * On page load
   */
  ngOnInit() {
    this.router.events.subscribe((event: Event) => {
      if (event instanceof NavigationEnd) {
        console.log("Current Route: " + event.url);
        this.currentRoute = event.url;
      }
    });
  }

  /**
   * returns if the page is home or not
   * @returns {boolean}
   */
  isHome(): boolean {
    return (this.currentRoute === "" || this.currentRoute === "/");
  }
}
