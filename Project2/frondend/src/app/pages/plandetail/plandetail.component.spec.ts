import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlandetailComponent } from './plandetail.component';

describe('PlandetailComponent', () => {
  let component: PlandetailComponent;
  let fixture: ComponentFixture<PlandetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlandetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlandetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
