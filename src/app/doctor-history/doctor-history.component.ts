import { Component, inject, OnInit } from '@angular/core';
import { AppoientmentSrvice } from '../services/appointment.service';
import { ClientService } from '../services/client.service';
import { Appointment } from '../Models/appointment';

@Component({
  selector: 'app-doctor-history',
  templateUrl: './doctor-history.component.html',
  styleUrl: './doctor-history.component.css'
})
export class DoctorHistoryComponent  implements OnInit{

  appointmentServ: AppoientmentSrvice = inject(AppoientmentSrvice);
  clientServ: ClientService = inject(ClientService);

  appointments: Appointment[];

  ngOnInit(): void {
    
    this.appointmentServ.getAppointmentsHistoryForDoctor(this.clientServ.user.userId).subscribe((res: Appointment[]) =>{

      this.appointments = res;
    })
  }

}
