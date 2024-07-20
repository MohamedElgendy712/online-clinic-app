package com.project.onlineClinic.service;

import com.project.onlineClinic.entity.User;
import com.project.onlineClinic.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServ {
    @Autowired
    UserRep userRep;


    public User getUserInfo(String email){
        return userRep.findByEmail(email);
    }
    public List<Object[]> findAllDoctors(){
        return userRep.test();
    }

}
