import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppoientmentPopupComponent } from './appoientment-popup.component';

describe('AppoientmentPopupComponent', () => {
  let component: AppoientmentPopupComponent;
  let fixture: ComponentFixture<AppoientmentPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AppoientmentPopupComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AppoientmentPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
