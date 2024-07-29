import { Component, inject, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AppoientmentSrvice } from '../services/appointment.service';

@Component({
  selector: 'app-appoientment-popup',
  templateUrl: './appoientment-popup.component.html',
  styleUrl: './appoientment-popup.component.css'
})
export class AppoientmentPopupComponent implements OnInit {

  @ViewChild('registrationForm') form: NgForm;
  appointmentService: AppoientmentSrvice = inject(AppoientmentSrvice);

  minDate: Date;

  ngOnInit(): void {
    this.minDate = new Date();
  }

  onFormSubmitted(){
    this.appointmentService.bookAppointment(this.form.value.appointment_date).subscribe((res) => {
      console.log(res);
      this.appointmentService.toggleAppointmentPopup();
    })
  }

  onCancel(){
    this.appointmentService.toggleAppointmentPopup();
  }
}
