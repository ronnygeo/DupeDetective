import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ComparedocumentsComponent} from './comparedocuments.component';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {DebugElement} from "@angular/core";
import {By} from "@angular/platform-browser";

describe('ComparedocumentsComponent', () => {
  let component: ComparedocumentsComponent;
  let fixture: ComponentFixture<ComparedocumentsComponent>;
  let de: DebugElement;
  let el: HTMLElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ComparedocumentsComponent],
      providers: [NgbActiveModal]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComparedocumentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have both students code blocks for compare', () => {
    const divs = fixture.debugElement.queryAll(By.css('div[class="col doc-compare-content"]'));
    expect(divs.length).toBeGreaterThanOrEqual(2);
  });

  it('should have close button enabled', () => {
    de = fixture.debugElement.query(By.css('button'));
    el = de.nativeElement;
    expect(el.innerText).toContain('×');
  });
});
