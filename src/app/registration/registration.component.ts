import { AfterViewInit, Component, OnInit, ViewChild, inject } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RegistrationService } from '../services/registration.service';



@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css',
})
export class RegistrationComponent implements OnInit {

  @ViewChild('registrationForm') form: NgForm | undefined;
  registerService: RegistrationService = inject(RegistrationService);

  specializations: string[] | undefined;

  ngOnInit(): void {
    this.specializations = ["spec1", "spec1", "spec1", "spec1", "spec1"]
  }

  

  onFormSubmitted(){
    this.registerService.register(this.form.value);
  }
}
