package com.project.onlineClinic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Password")
public class Password {
    @Id
    private String email;
    private String salt;
    @Column(name = "password")
    private String hashedPassword;
}
