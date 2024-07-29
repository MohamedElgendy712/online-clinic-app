import { RouterModule, Routes } from "@angular/router";
import { RegistrationComponent } from "./registration/registration.component";
import { NgModule } from "@angular/core";
import { LoginComponent } from "./login/login.component";
import { OtpComponent } from "./otp/otp.component";
import { HomeComponent } from "./home/home.component";
import { CategoriesComponent } from "./categories/categories.component";
import { ClientComponent } from "./client/client.component";
import { DoctorProfileComponent } from "./doctor-profile/doctor-profile.component";
import { AllDoctorsForSpecialization } from "./all-doctors-for-spec/all-doctors-for-spec.component";
import { ReviewPopUp } from "./review-popup/review-popup.component";
import { AppoientmentPopupComponent } from "./appoientment-popup/appoientment-popup.component";
import { AppointmentCardComponent } from "./appoinment-card/appointment-card.componenet";


const routes: Routes = [
    {path: '' , component: LoginComponent},
    {path: 'register' , component: RegistrationComponent},
    {path: 'otp' , component: OtpComponent},
    {path: 'home' , component: HomeComponent},
    {path: 'client' , component: ClientComponent},
    {path: 'allDoctors' , component: AllDoctorsForSpecialization},
    {path: 'doctorProfile' , component: DoctorProfileComponent}
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