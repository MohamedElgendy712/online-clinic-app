import { HttpClient } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { ClientService } from "./client.service";
import { User } from "../Models/user";
import { Review } from "../Models/review";

@Injectable({
    providedIn: 'root'
})
export class ReviewServ{
    http : HttpClient = inject(HttpClient)
    clientServ : ClientService = inject(ClientService)

    reviewPopup : boolean = false
    doctorInfo : User

    toggelReviewPopup(doctor? : User){
        this.doctorInfo = doctor

        this.reviewPopup = !this.reviewPopup
    }

    addReview(rating : number , review : string){
        let reviewBody = new Review(this.doctorInfo , this.clientServ.user.firstName , rating , review , new Date())
        
        console.log(reviewBody)

        return this.http.post("http://localhost:8080/user/addReview", reviewBody)
    }

}