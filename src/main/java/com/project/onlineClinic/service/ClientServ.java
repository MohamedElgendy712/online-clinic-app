package com.project.onlineClinic.service;

import com.project.onlineClinic.entity.User;
import com.project.onlineClinic.repository.ReviewRep;
import com.project.onlineClinic.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServ {
    @Autowired
    UserRep userRep;

    @Autowired
    ReviewRep reviewRep;

    public User getUserInfo(String email){
        return userRep.findByEmail(email);
    }
    public List<Object[]> findAllSpecialization(){
        return userRep.findAllSpecialization();
    }

    public List<Object[]> findAllDoctorForSpecialization(String specialization){
        return reviewRep.findAllDoctorForSpecialization(specialization);
    }

}
