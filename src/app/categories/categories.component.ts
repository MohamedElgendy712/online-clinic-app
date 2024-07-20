import { Component, inject, OnInit } from '@angular/core';
import { ClientService } from '../services/client.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrl: './categories.component.css'
})
export class CategoriesComponent implements OnInit {
  clientServ: ClientService = inject(ClientService);

  ngOnInit(): void {
    
  }
  
}
