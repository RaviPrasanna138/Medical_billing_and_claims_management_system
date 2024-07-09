import { TestBed } from '@angular/core/testing';

import { InsuranceCompanyServiceService } from './insurance-company-service.service';

describe('InsuranceCompanyServiceService', () => {
  let service: InsuranceCompanyServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InsuranceCompanyServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
