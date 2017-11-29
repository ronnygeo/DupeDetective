import {Component, CUSTOM_ELEMENTS_SCHEMA, OnInit} from '@angular/core';
import {Event, NavigationEnd, Router} from "@angular/router";
import {AlertService} from "./services/alert.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private message: any;

  private currentRoute;
  public currentUser;

  constructor(private router: Router, private alertService: AlertService) { }

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

    this.alertService.getMessage().subscribe(message => { this.message = message; });
  }

  /**
   * returns if the page is home or not
   * @returns {boolean}
   */
  isHome(): boolean {
    return (this.currentRoute === "" || this.currentRoute === "/");
  }
}
