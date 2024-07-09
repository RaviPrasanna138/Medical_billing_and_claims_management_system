import { TestBed } from '@angular/core/testing';

import { InvoiceDetailsServiceService } from './invoice-details-service.service';

describe('InvoiceDetailsServiceService', () => {
  let service: InvoiceDetailsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InvoiceDetailsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
