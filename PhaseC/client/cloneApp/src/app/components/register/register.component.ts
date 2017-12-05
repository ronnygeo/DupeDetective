import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {AlertService} from "../../services/alert.service";

/**
 * Register the user
 */
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  private name: string;
  private email: string;
  private username: string;
  private password: string;
  private confirmPassword: string;
  private grader: boolean = false;

  constructor(private userService: UserService, private router: Router,
              private alertService: AlertService) { }

  /**
   * On page load
   */
  ngOnInit() {}

  /**
   * Register the user
   */
  register(): void {
    if (this.password !== this.confirmPassword) this.alertService.error("Passwords don't match.");
    else {
      const data = {
        "name": this.name,
        "email": this.email,
        "username": this.username,
        "password": this.password,
        "grader": this.grader
      };
      this.userService.createUser(data).subscribe(user => {
        if (JSON.stringify(user) !== "undefined") {
          localStorage.setItem("currentUser", JSON.stringify(user));
          if (user && user.grader) {
            this.router.navigate(['/assignments']);
          } else if (user && !user.grader) {
            this.router.navigate(['/submissions/new']);
          }
        } else {
          this.alertService.error("User exists");
        }
      });
    }
  }

}
