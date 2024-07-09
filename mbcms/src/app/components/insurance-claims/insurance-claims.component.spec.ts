import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsuranceClaimsComponent } from './insurance-claims.component';

describe('InsuranceClaimsComponent', () => {
  let component: InsuranceClaimsComponent;
  let fixture: ComponentFixture<InsuranceClaimsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsuranceClaimsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsuranceClaimsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
