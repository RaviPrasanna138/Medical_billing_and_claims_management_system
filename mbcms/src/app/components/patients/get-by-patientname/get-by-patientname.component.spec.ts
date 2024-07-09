import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetByPatientnameComponent } from './get-by-patientname.component';

describe('GetByPatientnameComponent', () => {
  let component: GetByPatientnameComponent;
  let fixture: ComponentFixture<GetByPatientnameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetByPatientnameComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetByPatientnameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
