import { Component, inject, OnInit } from '@angular/core';
import { ClientService } from '../services/client.service';
import { specializationsImages } from '../lookup';
import { Router } from '@angular/router';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrl: './categories.component.css'
})
export class CategoriesComponent implements OnInit {
  clientServ: ClientService = inject(ClientService);
  allSpecialization: any;
  specializationsImgs = specializationsImages;

  router : Router = inject(Router)

  ngOnInit(): void {
    this.clientServ.getAllSpecializations().subscribe((res) => {
      console.log(res);
      this.allSpecialization = res;
    })
  }

  onShowDoctors(spec : string){
    this.router.navigate(['/allDoctors'] , {queryParams : {specialization : spec}})
  }


}
