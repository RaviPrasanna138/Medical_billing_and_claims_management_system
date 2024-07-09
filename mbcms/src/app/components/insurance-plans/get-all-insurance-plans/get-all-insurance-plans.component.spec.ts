import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllInsurancePlansComponent } from './get-all-insurance-plans.component';

describe('GetAllInsurancePlansComponent', () => {
  let component: GetAllInsurancePlansComponent;
  let fixture: ComponentFixture<GetAllInsurancePlansComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllInsurancePlansComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllInsurancePlansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
