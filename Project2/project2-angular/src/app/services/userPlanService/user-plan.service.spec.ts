import { TestBed } from '@angular/core/testing';

import { UserPlanService } from './user-plan.service';

describe('UserPlanService', () => {
  let service: UserPlanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserPlanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
