import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";

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

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  register(): void {
    this.router.navigate(['/submission/upload']);
  }

}
