import { TestBed } from '@angular/core/testing';

import { InsuranceClaimsServiceService } from './insurance-claims-service.service';

describe('InsuranceClaimsServiceService', () => {
  let service: InsuranceClaimsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InsuranceClaimsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
