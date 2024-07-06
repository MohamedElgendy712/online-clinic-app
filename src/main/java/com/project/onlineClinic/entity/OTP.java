package com.project.onlineClinic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "OTP")
public class OTP {

    @Id
    private String otpId;
    private String otpNo;
    private String creationDate;
}
