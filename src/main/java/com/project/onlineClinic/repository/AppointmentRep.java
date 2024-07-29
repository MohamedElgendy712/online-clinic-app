package com.project.onlineClinic.repository;

import com.project.onlineClinic.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRep extends JpaRepository<Appointment, Integer> {
}
