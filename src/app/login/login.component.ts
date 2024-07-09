import { Component, ViewChild, inject } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from '../services/login.service';
import { HttpErrorResponse } from '@angular/common/http';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {

  constructor(private messageService: MessageService) {}

  @ViewChild('registrationForm') form: NgForm;
  loginService: LoginService = inject(LoginService);

  onFormSubmitted() {
    this.loginService.login(this.form.value).subscribe((res) => {
      console.log(res);
    },
    (e : HttpErrorResponse)=>{
      this.messageService.add({ severity: 'error', summary: 'Error', detail: e.error })
    });
  }
}
