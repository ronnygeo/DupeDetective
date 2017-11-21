import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {User} from "../../models/user";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  login(): void {
    this.userService.getUser(this.username, this.password).subscribe(users => {
      if (users !== undefined && JSON.stringify(users) !== "undefined") {
        const user = users.filter(u => u["username"] === this.username && u["password"] === this.password)[0];
        localStorage.setItem("currentUser", JSON.stringify(user));
        if (user && user["grader"]) {
          this.router.navigate(['/assignments']);
        } else if (user && !user["grader"]) {
          this.router.navigate(['/submissions/new']);
        }
      }
    });
  }
}
