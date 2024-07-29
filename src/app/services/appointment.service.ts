import { inject, Injectable } from "@angular/core";
import { User } from "../Models/user";
import { ClientService } from "./client.service";
import { Appointment } from "../Models/appointment";
import { HttpClient } from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class AppoientmentSrvice{
    http: HttpClient = inject(HttpClient);
    clientServ: ClientService = inject(ClientService);

    appointmentPopup: boolean = false;
    doctorInfo: User;

    toggleAppointmentPopup(doctor? : User){

        console.log(doctor)
        console.log(this.clientServ.user)

        this.doctorInfo = doctor;

        this.appointmentPopup = !this.appointmentPopup;
    }

    bookAppointment(appointDate: Date){

        let appointment = new Appointment(this.clientServ.user , this.doctorInfo , appointDate , this.doctorInfo.specialization , "active");

        console.log(appointment)

        return this.http.post("http://localhost:8080/user/bookAppointment" , appointment);
    }

    getAllAppointmentForPatient(id : number){
        return this.http.get(`http://localhost:8080/user/getAllAppointmentForPatient/${id}`);
    }

    getAppointmentsHistoryForPatient(id: number){
        return this.http.get(`http://localhost:8080/user/getAppointmentsHistoryForPatient/${id}`);
    }

    cheangeAppointmentStatus(id : number , status : string){
        return this.http.put(`http://localhost:8080/user/updateAppointmentStatus` , {id : id , status : status});
    }
}