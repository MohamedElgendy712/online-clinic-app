import { User } from "./user";

export class Appointment{

    constructor(patient: User, doctor: User, sessionDate: Date, sessionSpecialization: string , sessionStatus: string){
        
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = sessionDate;
        this.appointmentSpecialization = sessionSpecialization;
        this.appointmentStatus = sessionStatus

    }
    appointmentId: number
    patient: User
    doctor: User
    appointmentDate: Date
    appointmentSpecialization: string
    appointmentStatus: string
}