import { Component, inject, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AppoientmentSrvice } from '../services/appointment.service';
import { ClientService } from '../services/client.service';
import { Appointment } from '../Models/appointment';

@Component({
  selector: 'app-client-appoientment',
  templateUrl: './client-appointment.component.html',
  styleUrl: './client-appointment.component.css'
})
export class ClientAppointmentComponent implements OnInit{

    appointmentServ : AppoientmentSrvice = inject(AppoientmentSrvice)
    clientServ : ClientService = inject(ClientService)

    appointments : Appointment[]

  ngOnInit(): void {
      this.appointmentServ.getAllAppointmentForPatient(this.clientServ.user.userId).subscribe({
        next: (res : Appointment[])=>{
            this.appointments = res
        }
      })
  }
}