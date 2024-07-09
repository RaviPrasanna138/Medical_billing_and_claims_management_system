import { TestBed } from '@angular/core/testing';

import { InsurancePlansServiceService } from './insurance-plans-service.service';

describe('InsurancePlansServiceService', () => {
  let service: InsurancePlansServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InsurancePlansServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
