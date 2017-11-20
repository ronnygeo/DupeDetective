import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComparedocumentsComponent } from './comparedocuments.component';

describe('ComparedocumentsComponent', () => {
  let component: ComparedocumentsComponent;
  let fixture: ComponentFixture<ComparedocumentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComparedocumentsComponent ]
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
});
