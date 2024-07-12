package com.project.onlineClinic.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Entity
@Component
@Data
@NoArgsConstructor
@Table(name = "OTP")
public class OTP {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID otpId;
    private int otpNo;
    private Date creationDate;


}
