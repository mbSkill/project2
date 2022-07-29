import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddplanComponent } from './addplan.component';

describe('AddplanComponent', () => {
  let component: AddplanComponent;
  let fixture: ComponentFixture<AddplanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddplanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddplanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
