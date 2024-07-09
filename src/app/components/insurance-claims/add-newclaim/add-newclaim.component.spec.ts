import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewclaimComponent } from './add-newclaim.component';

describe('AddNewclaimComponent', () => {
  let component: AddNewclaimComponent;
  let fixture: ComponentFixture<AddNewclaimComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNewclaimComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddNewclaimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
