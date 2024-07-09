import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthcareProviderComponent } from './healthcare-provider.component';

describe('HealthcareProviderComponent', () => {
  let component: HealthcareProviderComponent;
  let fixture: ComponentFixture<HealthcareProviderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HealthcareProviderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HealthcareProviderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
