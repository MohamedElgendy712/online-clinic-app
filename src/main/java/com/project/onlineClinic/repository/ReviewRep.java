package com.project.onlineClinic.repository;

import com.project.onlineClinic.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRep extends JpaRepository<Review , Integer> {

    @Query("SELECT u.userId, u.firstName, u.lastName, u.experience, u.email, u.specialization, t.noReviews, t.rating " +
            "FROM (SELECT r.doctor.userId AS doctorId, COUNT(r) AS noReviews, AVG(r.rating) AS rating FROM Review r GROUP BY r.doctor.userId) t " +
            "JOIN User u ON (t.doctorId = u.userId and u.specialization = :spec)")
    List<Object[]> findAllDoctorForSpecialization(@Param("spec") String Specialization);
}
