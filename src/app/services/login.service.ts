import { HttpClient } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import {  UserInfo } from "../Models/userInfo";

@Injectable({
    providedIn: "root"
})
export class LoginService{
    http:HttpClient = inject(HttpClient);

    login(user: UserInfo){
        
        this.http.post("" , user).subscribe((res) => {
            console.log(res);
        })
    }
}