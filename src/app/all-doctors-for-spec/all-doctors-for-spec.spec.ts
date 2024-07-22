import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorProfileComponent } from './all-doctors-for-spec.component';

describe('DoctorProfileComponent', () => {
  let component: DoctorProfileComponent;
  let fixture: ComponentFixture<DoctorProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DoctorProfileComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DoctorProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
