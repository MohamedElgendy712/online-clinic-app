import { HttpClient } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import {  UserInfo } from "../Models/userInfo";

@Injectable({
    providedIn: "root"
})
export class LoginService{
    http:HttpClient = inject(HttpClient);

    login(user: UserInfo){
        
        return this.http.post("http://localhost:8080/registrationLogin/login" , user)
    }
}