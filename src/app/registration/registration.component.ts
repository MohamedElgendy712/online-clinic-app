import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';



@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css',
})
export class RegistrationComponent implements OnInit {

  @ViewChild('registrationForm') form: NgForm | undefined;

  specializations: string[] | undefined;

  ngOnInit(): void {
    this.specializations = ["spec1", "spec1", "spec1", "spec1", "spec1"]
  }

  

  onFormSubmitted(){
    console.log(this.form)
  }
}
