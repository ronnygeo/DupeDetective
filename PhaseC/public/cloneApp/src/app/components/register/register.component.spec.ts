import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {RegisterComponent} from './register.component';
import {FormsModule} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {HttpClient, HttpClientModule, HttpHandler} from "@angular/common/http";
import {Router} from "@angular/router";
import {DebugElement} from "@angular/core";
import {By} from "@angular/platform-browser";

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;
  let de: DebugElement;
  let el: HTMLElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [FormsModule],
      declarations: [RegisterComponent],
      providers: [UserService, HttpClientModule, HttpClient, HttpHandler, {
        provide: Router, useClass: class {
          navigate = jasmine.createSpy("navigate");
        }
      }]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have register link', () => {
    de = fixture.debugElement.query(By.css('a'));
    el = de.nativeElement;
    expect(el.textContent).toContain('Register');
  });

  it('should have register header', () => {
    de = fixture.debugElement.query(By.css('div[class="card-header"]'));
    el = de.nativeElement;
    expect(el.textContent).toContain('Register');
  });

  it('should have link to login for already registered users', () => {
    de = fixture.debugElement.query(By.css('a[routerLink="/login"]'));
    el = de.nativeElement;
    expect(el.textContent).toContain('Login here');
  });


});
