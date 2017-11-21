import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {User} from "../../models/user";

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
  private grader: boolean;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  register(): void {
    const data = {"name": this.name, "email": this.email, "username": this.username, "password": this.password}
    this.userService.createUser(data).subscribe(user => {
      localStorage.setItem("currentUser", JSON.stringify(user));
      this.router.navigate(['/submissions/new']);
    });
  }

}
