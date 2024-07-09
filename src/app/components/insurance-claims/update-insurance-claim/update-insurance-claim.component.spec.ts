import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateInsuranceClaimComponent } from './update-insurance-claim.component';

describe('UpdateInsuranceClaimComponent', () => {
  let component: UpdateInsuranceClaimComponent;
  let fixture: ComponentFixture<UpdateInsuranceClaimComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateInsuranceClaimComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateInsuranceClaimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
