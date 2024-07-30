import { Component, inject, OnInit } from '@angular/core';
import { Appointment } from '../Models/appointment';
import { ClientService } from '../services/client.service';
import { AppoientmentSrvice } from '../services/appointment.service';

@Component({
  selector: 'app-doctor-appointment',
  templateUrl: './doctor-appointment.component.html',
  styleUrl: './doctor-appointment.component.css'
})
export class DoctorAppointmentComponent implements OnInit {

  appointmentServ: AppoientmentSrvice = inject(AppoientmentSrvice);
  clientServ: ClientService = inject(ClientService);

  appointments: Appointment[];

  ngOnInit(): void {
    
    this.appointmentServ.getAllAppointmentForDoctor(this.clientServ.user.userId).subscribe((res: Appointment[]) =>{

      this.appointments = res;
      
    })
  }

}
