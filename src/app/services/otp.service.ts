import { HttpClient } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { Otp } from "../Models/otp";

@Injectable({
    providedIn : 'root'
})
export class OtpService{

    http: HttpClient = inject(HttpClient)

    otpPopup : boolean = false
    email: string
    otp: Otp

    toggelOtpPopup(email?:string){
        this.email = email

        this.otpPopup = !this.otpPopup
    }

    sendOtp(){
        this.http.post("http://localhost:8080/otp/generate", {email : this.email})
        .subscribe({
            next: (res : Otp)=>{
                this.otp = res
            }
        })
    }

    verifyOtp(otpNo : number){
        
        this.otp.otpNo = otpNo

        return this.http.post("http://localhost:8080/otp/check", this.otp)
    }
}