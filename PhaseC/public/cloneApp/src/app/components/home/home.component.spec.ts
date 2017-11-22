import {HomeComponent} from "./home.component";
import {async, ComponentFixture, TestBed} from "@angular/core/testing";
import {FormsModule} from "@angular/forms";
import {DebugElement} from "@angular/core";
import {By} from "@angular/platform-browser";


describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;
  let de: DebugElement;
  let el: HTMLElement;

  beforeEach(async(() => {
      TestBed.configureTestingModule({
        imports: [FormsModule],
        declarations: [HomeComponent], // Declare the test component

      })
        .compileComponents();
    }
  ));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance; // HomeComponent test instance
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have app name as title', () => {
    de = fixture.debugElement.query(By.css('h1'));
    el = de.nativeElement;
    expect(el.textContent).toContain('Dupe Detective');
  });

  it('should have register links for students and graders', () => {
    const registerLinks = fixture.debugElement.queryAll(By.css('a[routerLink="/register"]'));

    expect(registerLinks.length).toBeGreaterThanOrEqual(2);
  });
});
