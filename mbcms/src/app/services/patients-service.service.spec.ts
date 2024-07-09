import { TestBed } from '@angular/core/testing';

import { PatientsServiceService } from './patients-service.service';

describe('PatientsServiceService', () => {
  let service: PatientsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PatientsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
