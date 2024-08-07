import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../Models/user';
import { ClientService } from '../services/client.service';
import { ReviewServ } from '../services/review.service';
import { AppoientmentSrvice } from '../services/appointment.service';

@Component({
  selector: 'doctor-profile',
  templateUrl: './doctor-profile.component.html',
  styleUrl: './doctor-profile.component.css'
})
export class DoctorProfileComponent implements OnInit {

  clientService: ClientService = inject(ClientService);
  activeRoute: ActivatedRoute = inject(ActivatedRoute);
  reviewServ : ReviewServ = inject(ReviewServ);
  appointmentService: AppoientmentSrvice = inject(AppoientmentSrvice);

  doctorId: string;
  doctorInfo: User;
  allReview: any;


  ngOnInit(): void {
    
    this.activeRoute.queryParamMap.subscribe((data) => {
      this.doctorId = data.get('doctorId');
    })

    this.clientService.getDoctorById(this.doctorId).subscribe((res: User) =>{
      console.log(res);
      this.doctorInfo = res;
    })

    
    this.clientService.getAllReviewsForDoctor(this.doctorId).subscribe((res) => {
      console.log(res);
      this.allReview = res;
    })
      
  }


  addReview(){
    this.reviewServ.toggelReviewPopup(this.doctorInfo)
  }

  bookAppointment(){
    this.appointmentService.toggleAppointmentPopup(this.doctorInfo)
  }

}
