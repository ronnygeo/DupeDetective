import {ReportComponent} from "./report.component";
import {async, ComponentFixture, TestBed} from "@angular/core/testing";
import {DebugElement} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {By} from "@angular/platform-browser";
describe('ReportComponent', () => {
  let component: ReportComponent;
  let fixture: ComponentFixture<ReportComponent>;


  beforeEach(async(() => {
      TestBed.configureTestingModule({
        imports: [FormsModule],
        declarations: [ReportComponent], // Declare the test component

      })
        .compileComponents();
    }
  ));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportComponent);
    component = fixture.componentInstance; // ReportComponent test instance
    fixture.detectChanges();
  });

  // it('should create', () => {
  //   expect(component).toBeTruthy();
  // });

  // it('should have app name as title', () => {
  //   de = fixture.debugElement.query(By.css('h1'));
  //   el = de.nativeElement;
  //   expect(el.textContent).toContain('Dupe Detective');
  // });


});
