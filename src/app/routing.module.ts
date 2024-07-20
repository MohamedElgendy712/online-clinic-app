import { RouterModule, Routes } from "@angular/router";
import { RegistrationComponent } from "./registration/registration.component";
import { NgModule } from "@angular/core";
import { LoginComponent } from "./login/login.component";
import { OtpComponent } from "./otp/otp.component";
import { HomeComponent } from "./home/home.component";
import { CategoriesComponent } from "./categories/categories.component";


const routes: Routes = [
    {path: '' , component: RegistrationComponent},
    {path: 'login' , component: LoginComponent},
    {path: 'otp' , component: OtpComponent},
    {path: 'home' , component: HomeComponent},
    {path: 'client' , children: [
        {path: 'categories' , component: CategoriesComponent}
    ]}
]


@NgModule({
    imports:[
        RouterModule.forRoot(routes)
    ],
    exports:[
        RouterModule
    ]
})

export class RoutingModule{

}