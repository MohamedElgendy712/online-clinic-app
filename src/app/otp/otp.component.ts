import { AfterViewInit, Component, inject, OnInit } from '@angular/core';
import { CardModule } from 'primeng/card';
import { InputOtpModule } from 'primeng/inputotp'; 
import { OtpService } from '../services/otp.service';
import { MessageService } from 'primeng/api';
import { Router } from '@angular/router';
import { RegistrationService } from '../services/registration.service';
import { ClientService } from '../services/client.service';
@Component({
  selector: 'app-otp',
  templateUrl: './otp.component.html',
  styleUrl: './otp.component.css'
})
export class OtpComponent implements OnInit {

  otpService : OtpService = inject(OtpService)
  messageService: MessageService = inject(MessageService)
  router : Router = inject(Router)
  registartionService: RegistrationService = inject(RegistrationService)
  clientService: ClientService = inject(ClientService)

  otpValue : number

  onVerifyOtp(){
    this.otpService.verifyOtp(this.otpValue).subscribe(
      {
        next: (res)=>{
          //this.otpService.toggelOtpPopup()
          this.clientService.getUser(this.otpService.email)
        },
        error: (e)=>{
          this.messageService.add({ severity: 'error', summary: 'Error', detail: e.error.message })
        }
      }
    )
  }

  ngOnInit(): void {
    this.otpService.sendOtp();
  }
}
