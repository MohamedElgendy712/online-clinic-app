import { Component, ViewChild, inject } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from '../services/login.service';
import { HttpErrorResponse } from '@angular/common/http';
import { MessageService } from 'primeng/api';
import { OtpService } from '../services/otp.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {

  @ViewChild('registrationForm') form: NgForm;

  loginService: LoginService = inject(LoginService);
  messageService: MessageService = inject(MessageService)
  otpService : OtpService = inject(OtpService)

  onFormSubmitted() {
    this.loginService.login(this.form.value).subscribe((res) => {
      this.otpService.toggelOtpPopup(this.form.value.email)
    },
    (e : HttpErrorResponse)=>{
      this.messageService.add({ severity: 'error', summary: 'Error', detail: e.error.message })
    });
  }
}
