package com.project.onlineClinic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Appointments")
public class Appointment {

    public Appointment(User patinet , User doctor , Date appointmentDate , String appointmentSpecialization , String appointmentStatus){
        this.patient = patinet;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.appointmentSpecialization = appointmentSpecialization;
        this.appointmentStatus = appointmentStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    @ManyToOne
    @JoinColumn(name = "patientId" , referencedColumnName = "userId" , nullable = false)
    private User patient;

    @ManyToOne
    @JoinColumn(name = "doctorId" , referencedColumnName = "userId" , nullable = false)
    private User doctor;

    private Date appointmentDate;

    private String appointmentSpecialization;

    private String appointmentStatus;
}
