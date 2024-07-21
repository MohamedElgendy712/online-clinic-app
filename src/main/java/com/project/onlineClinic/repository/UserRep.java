package com.project.onlineClinic.repository;

import com.project.onlineClinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRep extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    @Query(value = "SELECT u.specialization , COUNT(u) FROM User u WHERE u.isDoctor = true GROUP BY u.specialization")
    List<Object[]> findAllSpecialization();
}
