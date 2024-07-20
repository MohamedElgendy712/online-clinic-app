import {
  AfterViewInit,
  Component,
  OnInit,
  ViewChild,
  inject,
} from '@angular/core';
import { NgForm } from '@angular/forms';
import { RegistrationService } from '../services/registration.service';
import { HttpErrorResponse } from '@angular/common/http';
import { MessageService } from 'primeng/api';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css',
})
export class RegistrationComponent implements OnInit {
  @ViewChild('registrationForm') form: NgForm | undefined;

  registerService: RegistrationService = inject(RegistrationService);
  messageService: MessageService = inject(MessageService);
  router: Router = inject(Router);

  specializations: string[] | undefined;

  ngOnInit(): void {
    this.specializations = ['Dentistry', 'Internal Medicine', 'Dermatology', 'Ophthalmology', 'Urology', 'Surgery', 'Orthopedics', 'Otolaryngology (ENT)'];
  }

  onFormSubmitted() {
    this.registerService.register(this.form.value).subscribe({
      next: (res) => {
        this.router.navigate(['login'])
      },
      error: (e: HttpErrorResponse) => {
        this.messageService.add({
          severity: 'error',
          summary: 'Error',
          detail: e.error.message,
        });
      },
    });
  }
}
