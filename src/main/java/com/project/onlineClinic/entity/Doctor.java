package com.project.onlineClinic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Doctor")
public class Doctor {

    public Doctor(String firstName, String lastName, String gender, String email, String phone, String birthDate, String specialization, int experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.specialization = specialization;
        this.experience = experience;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;
    private String firstName;
    private String lastName;
    private String gender;
    @Column(unique = true)
    private String email;
    private String phone;
    private String birthDate;
    private String specialization;
    private int experience;
}
