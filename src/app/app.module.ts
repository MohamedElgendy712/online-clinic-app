import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RoutingModule } from './routing.module';
import { InputTextModule } from 'primeng/inputtext';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { InputNumberModule } from 'primeng/inputnumber';
import { FloatLabelModule } from 'primeng/floatlabel';
import { CalendarModule } from 'primeng/calendar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { RadioButtonModule } from 'primeng/radiobutton';
import { CheckboxModule } from 'primeng/checkbox';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';
import { PasswordModule } from 'primeng/password';
import { ToastModule } from 'primeng/toast';
import { CardModule } from 'primeng/card';
import { InputOtpModule } from 'primeng/inputotp';
import { RatingModule } from 'primeng/rating';

import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { MessageService } from 'primeng/api';
import { OtpComponent } from './otp/otp.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AvatarModule } from 'primeng/avatar';
import { CategoriesComponent } from './categories/categories.component';
import { TabViewModule } from 'primeng/tabview';
import { ClientComponent } from './client/client.component';
import { DoctorProfileComponent } from './doctor-profile/doctor-profile.component';
import { AllDoctorsForSpecialization } from './all-doctors-for-spec/all-doctors-for-spec.component';
import { ReviewPopUp } from './review-popup/review-popup.component';
import { AppoientmentPopupComponent } from './appoientment-popup/appoientment-popup.component';



@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    OtpComponent,
    HomeComponent,
    NavbarComponent,
    CategoriesComponent,
    ClientComponent,
    DoctorProfileComponent,
    AllDoctorsForSpecialization,
    ReviewPopUp,
    AppoientmentPopupComponent
  ],
  imports: [
    BrowserModule,
    RoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    InputTextModule,
    InputTextareaModule,
    RatingModule,
    FloatLabelModule,
    InputNumberModule,
    CalendarModule,
    RadioButtonModule,
    CheckboxModule,
    DropdownModule,
    ButtonModule,
    PasswordModule,
    HttpClientModule,
    ToastModule,
    CardModule,
    InputOtpModule,
    AvatarModule,
    TabViewModule
  ],
  providers: [MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
