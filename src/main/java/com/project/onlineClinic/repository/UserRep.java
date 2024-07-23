package com.project.onlineClinic.repository;

import com.project.onlineClinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRep extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findById(int id);
    @Query(value = "SELECT u.specialization , COUNT(u) FROM User u WHERE u.isDoctor = true GROUP BY u.specialization")
    List<Object[]> findAllSpecialization();
}
