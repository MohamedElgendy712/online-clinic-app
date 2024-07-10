package com.project.onlineClinic.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Patient")
public class Patient {

    public Patient(String firstName, String lastName, String gender, String email, String phone, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    private String firstName;
    private String lastName;
    private String gender;
    @Column(unique = true)
    private String email;
    private String phone;
    private String birthDate;
}
