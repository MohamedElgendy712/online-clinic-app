import { Component, ViewChild, inject } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  @ViewChild('registrationForm') form: NgForm;
  loginService: LoginService = inject(LoginService);

  onFormSubmitted(){
    this.loginService.login(this.form.value);
  }
}
