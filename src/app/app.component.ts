import { Component, inject, OnInit } from '@angular/core';
import { ClientService } from './services/client.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'online-clinic';

  clientServ : ClientService = inject(ClientService)

  ngOnInit(): void {
    this.clientServ.getUser()
  }
}
