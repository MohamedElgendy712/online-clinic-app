import { HttpClient } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { User } from "../Models/user";
import { Router } from "@angular/router";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class ClientService{

    http: HttpClient = inject(HttpClient);
    router: Router = inject(Router);
    user: User;


    getUser(email: string){
        console.log(email)

        this.http.get(`http://localhost:8080/user/getUserInfo/${email}`).subscribe(
            (res: User)=>{
            
            this.user = res;

            if(this.user.isDoctor){
                this.router.navigate(['home']);
            }else{
                this.router.navigate(['client']);
            }
        })
    }

    getAllSpecializations(){
        return this.http.get("http://localhost:8080/user/getAllSpecialization")
    }

    getAllDoctorsForSpecialization(spec : string){
        return this.http.get(`http://localhost:8080/user/getAllDoctorForSpec/${spec}`)
    }

    getDoctorById(id: string){
        return this.http.get(`http://localhost:8080/user/getDoctorById/${id}`)
    }

    getAllReviewsForDoctor(doctorId: string){
        return this.http.get(`http://localhost:8080/user/getAllReviewsForDoctor/${doctorId}`)
    }
}