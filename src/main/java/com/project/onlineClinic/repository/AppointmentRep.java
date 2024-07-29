package com.project.onlineClinic.repository;

import com.project.onlineClinic.entity.Appointment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRep extends JpaRepository<Appointment, Integer> {
    @Query("Select a from Appointment a where a.patient.userId = :id and a.appointmentStatus = 'active'")
    List<Appointment> getAllAppointmentForPatient(@Param("id") int id);

    @Query("Select a from Appointment a where a.patient.userId = :id and a.appointmentStatus != 'active'")
    List<Appointment> getAppointmentsHistoryForPatient(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("Update Appointment a Set a.appointmentStatus = :status Where a.appointmentId = :id")
    void updateAppointmentStatus(@Param("id") int id, @Param("status") String status);

}
