import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {LoginComponent} from './login.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule, HttpClient, HttpHandler} from '@angular/common/http';
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {DebugElement} from "@angular/core";
import {By} from "@angular/platform-browser";

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let de: DebugElement;
  let el: HTMLElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [FormsModule],
      declarations: [LoginComponent], // Declare the test component
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
    component = fixture.componentInstance; // LoginComponent test instance
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display login header', () => {
    de = fixture.debugElement.query(By.css('div[class="card-header"]'));
    el = de.nativeElement;
    expect(el.textContent).toContain('Login');
  });

  it('should display login header', () => {
    de = fixture.debugElement.query(By.css('div[class="card-header"]'));
    el = de.nativeElement;
    expect(el.textContent).toContain('Login');
  });

  it('should have username and password inputs', () => {
    de = fixture.debugElement.query(By.css('input[name="username"]'));
    el = de.nativeElement;
    expect(el.contentEditable).toBeTruthy();

    de = fixture.debugElement.query(By.css('input[name="password"]'));
    el = de.nativeElement;
    expect(el.contentEditable).toBeTruthy();

  });

});
