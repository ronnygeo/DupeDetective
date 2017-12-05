import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {AlertService} from "../../services/alert.service";

/**
 * Handle user login
 */
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;
  constructor(private userService: UserService, private router: Router,
              private alertService: AlertService) { }

  /**
   * On page load
   */
  ngOnInit() {}

  /**
   * Login the user
   */
  login(): void {
    this.userService.getUser(this.username, this.password).subscribe(user => {
      if (user !== undefined && JSON.stringify(user) !== "undefined") {
        localStorage.setItem("currentUser", JSON.stringify(user));
        if (user && user["grader"]) {
          this.router.navigate(['/assignments']);
        } else if (user && !user["grader"]) {
          this.router.navigate(['/submissions/new']);
        }
      } else {
        this.alertService.error("Username password combination not found.")
      }
    });
  }
}
