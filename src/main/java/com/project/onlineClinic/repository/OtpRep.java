package com.project.onlineClinic.repository;

import com.project.onlineClinic.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OtpRep extends JpaRepository<OTP, UUID> {
}
