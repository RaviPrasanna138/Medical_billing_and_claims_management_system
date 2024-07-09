import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetInvoiceByPatientnameComponent } from './get-invoice-by-patientname.component';

describe('GetInvoiceByPatientnameComponent', () => {
  let component: GetInvoiceByPatientnameComponent;
  let fixture: ComponentFixture<GetInvoiceByPatientnameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetInvoiceByPatientnameComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetInvoiceByPatientnameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
