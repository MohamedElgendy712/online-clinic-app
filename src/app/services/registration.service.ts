import { HttpClient } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { User } from "../Models/user";


@Injectable({
    providedIn: "root"
})
export class RegistrationService{
    http: HttpClient = inject(HttpClient);

    register(user: User){
        
        this.http.post("" , user).subscribe((res) =>{
            console.log(res);
        });
        
    }
}