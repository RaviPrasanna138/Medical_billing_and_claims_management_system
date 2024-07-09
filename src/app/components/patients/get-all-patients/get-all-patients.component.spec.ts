import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllPatientsComponent } from './get-all-patients.component';

describe('GetAllPatientsComponent', () => {
  let component: GetAllPatientsComponent;
  let fixture: ComponentFixture<GetAllPatientsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllPatientsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllPatientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
