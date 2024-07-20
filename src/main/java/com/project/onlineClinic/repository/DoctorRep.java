package com.project.onlineClinic.repository;

import com.project.onlineClinic.dto.SpecializationDTO;
import com.project.onlineClinic.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRep extends JpaRepository<Doctor , Integer> {


    @Query(value = "SELECT d.specialization , COUNT(d) FROM Doctor d GROUP BY d.specialization")
    List<Object[]> test();
}
