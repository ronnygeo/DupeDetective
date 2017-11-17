import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";

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
    localStorage.setItem('currentUser', JSON.stringify({"username": this.username, "password": this.password, "grader": true}));
    // TODO: Move to user service
    const grader = true;
    if (grader) {
    this.router.navigate(['/assignments']);
    } else {
      this.router.navigate(['/submission/upload']);
    }

  }
}
