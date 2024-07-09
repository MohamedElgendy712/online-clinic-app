import { HttpClient } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { User } from "../Models/user";


@Injectable({
    providedIn: "root"
})
export class RegistrationService{
    http: HttpClient = inject(HttpClient);

    register(user: User){
        
        return this.http.post("http://localhost:8080/registrationLogin/register" , user)
        
    }
}