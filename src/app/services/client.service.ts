import { HttpClient } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { User } from "../Models/user";
import { Router } from "@angular/router";

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

            console.log(this.user)

            if(Object.hasOwn(this.user , "isDoctor")){
                console.log("innn")
                this.router.navigate['home'];
            }else{
                console.log("test")
                this.router.navigate['home'];
            }
        })
    }

    getSpecializations(){
        return this.http.get("http://localhost:8080/registrationLogin/test")
    }
}