import { TestBed } from '@angular/core/testing';

import { HealthcareProviderServiceService } from './healthcare-provider-service.service';

describe('HealthcareProviderServiceService', () => {
  let service: HealthcareProviderServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HealthcareProviderServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
