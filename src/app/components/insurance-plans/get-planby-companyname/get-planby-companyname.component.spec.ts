import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetPlanbyCompanynameComponent } from './get-planby-companyname.component';

describe('GetPlanbyCompanynameComponent', () => {
  let component: GetPlanbyCompanynameComponent;
  let fixture: ComponentFixture<GetPlanbyCompanynameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetPlanbyCompanynameComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetPlanbyCompanynameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
