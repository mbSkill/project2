import { TestBed } from '@angular/core/testing';

import { UserplanService } from './userplan.service';

describe('UserplanService', () => {
  let service: UserplanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserplanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
