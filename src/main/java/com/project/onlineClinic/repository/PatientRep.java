package com.project.onlineClinic.repository;

import com.project.onlineClinic.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRep extends JpaRepository<Patient , Integer> {
}
