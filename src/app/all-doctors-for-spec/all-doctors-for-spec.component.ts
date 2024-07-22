import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClientService } from '../services/client.service';

@Component({
  selector: 'all-doctors-for-spec',
  templateUrl: './all-doctors-for-spec.component.html',
  styleUrl: './all-doctors-for-spec.component.css'
})
export class AllDoctorsForSpecialization implements OnInit {

  specialization : string
  allDoctor : any

  activatRoute : ActivatedRoute = inject(ActivatedRoute)
  clientServ : ClientService = inject(ClientService)

  ngOnInit(): void {
    this.activatRoute.queryParamMap.subscribe((data)=>{
      this.specialization = data.get('specialization')
    })

    this.clientServ.getAllDoctorsForSpecialization(this.specialization).subscribe(
      {
        next: (res)=>{
          console.log(res)
          this.allDoctor = res
        }
      }
    )
  }
}
