package com.project.onlineClinic.service;

import com.project.onlineClinic.dto.SpecializationDTO;
import com.project.onlineClinic.entity.Doctor;
import com.project.onlineClinic.repository.DoctorRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServ {
    @Autowired
    DoctorRep doctorRep;

    public List<Object[]> findAllDoctors(){
        return doctorRep.test();
    }

}
