import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllDoctorsForSpecialization } from './all-doctors-for-spec.component';

describe('DoctorProfileComponent', () => {
  let component: AllDoctorsForSpecialization;
  let fixture: ComponentFixture<AllDoctorsForSpecialization>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AllDoctorsForSpecialization]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllDoctorsForSpecialization);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
