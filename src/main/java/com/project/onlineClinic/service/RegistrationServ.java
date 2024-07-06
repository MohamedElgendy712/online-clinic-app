package com.project.onlineClinic.service;

import com.project.onlineClinic.dto.UserInfoDTO;
import com.project.onlineClinic.entity.Doctor;
import com.project.onlineClinic.entity.Patient;
import com.project.onlineClinic.repository.DoctorRep;
import com.project.onlineClinic.repository.PatientRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServ {

    @Autowired
    private DoctorRep doctorRep;

    @Autowired
    private PatientRep patientRep;

    public boolean registerUser(UserInfoDTO user){
        if(user.isDoctor()){
            Doctor doctor = new Doctor(user.getFirstName(),user.getLastName(),user.getGender()
                                        ,user.getEmail(),user.getPhone(),user.getBirthDate()
                                        ,user.getSpecialization(),user.getExperience());

            doctorRep.save(doctor);
        }
        else{

            Patient patient = new Patient(user.getFirstName(),user.getLastName(),user.getGender()
                    ,user.getEmail(),user.getPhone(),user.getBirthDate());

            patientRep.save(patient);
        }

        return true;
    }
}
