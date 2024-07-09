import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllInsuranceClaimsComponent } from './get-all-insurance-claims.component';

describe('GetAllInsuranceClaimsComponent', () => {
  let component: GetAllInsuranceClaimsComponent;
  let fixture: ComponentFixture<GetAllInsuranceClaimsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllInsuranceClaimsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllInsuranceClaimsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
