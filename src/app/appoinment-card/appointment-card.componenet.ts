import { Component, inject, Input, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AppoientmentSrvice } from '../services/appointment.service';
import { Appointment } from '../Models/appointment';
import { ClientService } from '../services/client.service';

@Component({
  selector: 'app-appoientment-card',
  templateUrl: './appointment-card.component.html',
  styleUrl: './appointment-card.component.css'
})
export class AppointmentCardComponent {

    @Input() appointment : Appointment

    clientServ : ClientService = inject(ClientService)
    appointmentServ : AppoientmentSrvice = inject(AppoientmentSrvice)

    onChangeAppointmentStatus(id: number , status : string){
        console.log(status)
        this.appointmentServ.changeAppointmentStatus(id , status).subscribe({
          next:(res)=>{
            console.log(res)
          }
        })
    }
  
}