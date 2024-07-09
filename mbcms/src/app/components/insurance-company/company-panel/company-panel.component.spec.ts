import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyPanelComponent } from './company-panel.component';

describe('CompanyPanelComponent', () => {
  let component: CompanyPanelComponent;
  let fixture: ComponentFixture<CompanyPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompanyPanelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CompanyPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
