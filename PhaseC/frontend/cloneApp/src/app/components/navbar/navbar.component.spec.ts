import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {NavbarComponent} from './navbar.component';
import {Router} from "@angular/router";
import {DebugElement} from "@angular/core";
import {By} from "@angular/platform-browser";

// describe('NavbarComponent', () => {
//   let component: NavbarComponent;
//   let fixture: ComponentFixture<NavbarComponent>;
//   let de: DebugElement;
//   let el: HTMLElement;
//
//   beforeEach(async(() => {
//     TestBed.configureTestingModule({
//       declarations: [NavbarComponent],
//       providers: [{
//         provide: Router, useClass: class {
//           navigate = jasmine.createSpy("navigate");
//         }
//       }]
//     })
//       .compileComponents();
//   }));
//
//   beforeEach(() => {
//     fixture = TestBed.createComponent(NavbarComponent);
//     component = fixture.componentInstance;
//     fixture.detectChanges();
//   });
//
//   it('should have link to homepage', () => {
//     de = fixture.debugElement.query(By.css('a'));
//     el = de.nativeElement;
//     expect(el.textContent).toContain('Dupe Detective');
//   });
//
//
// });
