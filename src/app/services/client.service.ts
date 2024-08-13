import { HttpClient } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { User } from "../Models/user";
import { Router } from "@angular/router";
import { Observable, Subject } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class ClientService{

    http: HttpClient = inject(HttpClient);
    router: Router = inject(Router);
    user: User;

    obs = new Subject<User>()

    getUser(){
        this.http.get(`http://localhost:8080/user/getUserInfo` , {withCredentials:true}).subscribe(
            (res: User)=>{
            
            this.user = res;
            this.notifyUser(res)

            if(this.user.isDoctor){
                this.router.navigate(['doctor']);
            }else{
                this.router.navigate(['client']);
            }
        })
    }

    notifyUser(user? : User){
        console.log(user)
        this.obs.next(user)
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