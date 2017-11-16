import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";

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

  constructor(userService: UserService) { }

  ngOnInit() {
  }

  register(): void {

  }

}
