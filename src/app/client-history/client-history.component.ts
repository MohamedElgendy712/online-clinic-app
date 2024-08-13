import { Component, inject, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AppoientmentSrvice } from '../services/appointment.service';
import { ClientService } from '../services/client.service';
import { Appointment } from '../Models/appointment';
import { User } from '../Models/user';

@Component({
  selector: 'app-client-history',
  templateUrl: './client-history.component.html',
  styleUrl: './client-history.component.css'
})
export class ClientHistoryComponent implements OnInit{

    appointmentServ : AppoientmentSrvice = inject(AppoientmentSrvice)
    clientServ : ClientService = inject(ClientService)

    appointments : Appointment[]

  ngOnInit(): void {
      this.clientServ.obs.subscribe({
        next: (user : User)=>{
          this.appointmentServ.getAppointmentsHistoryForPatient(user.userId).subscribe({
            next: (res : Appointment[])=>{
                this.appointments = res
            }
          })
        }
      })
  }
}