import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {LoginComponent} from './login.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule, HttpClient, HttpHandler} from '@angular/common/http';
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [FormsModule],
      declarations: [LoginComponent],
      providers: [UserService, HttpClientModule, HttpClient, HttpHandler, {
        provide: Router, useClass: class {
          navigate = jasmine.createSpy("navigate");
        }
      }]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
