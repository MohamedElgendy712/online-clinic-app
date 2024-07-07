package com.project.onlineClinic.repository;

import com.project.onlineClinic.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswoedRep extends JpaRepository<Password , String> {
}
