package com.project.onlineClinic.repository;

import com.project.onlineClinic.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRep extends JpaRepository<Doctor , Integer> {
}
