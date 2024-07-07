package com.project.onlineClinic.service;

import com.project.onlineClinic.dto.UserInfoDTO;
import com.project.onlineClinic.entity.Doctor;
import com.project.onlineClinic.entity.Password;
import com.project.onlineClinic.entity.Patient;
import com.project.onlineClinic.repository.DoctorRep;
import com.project.onlineClinic.repository.PasswoedRep;
import com.project.onlineClinic.repository.PatientRep;
import com.project.onlineClinic.utility.PasswordManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationServ {

    @Autowired
    private DoctorRep doctorRep;

    @Autowired
    private PatientRep patientRep;

    @Autowired
    private PasswoedRep passwoedRep;
    @Autowired
    private PasswordManagement passwordManagement;

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

        savePassword(user.getEmail() , user.getPassword());

        return true;
    }

    public void savePassword(String email , String password){

        System.out.println("**************** innn **************");
        String hashedPassword = passwordManagement.generateSaltedHash(password);

        Password passwordRecord = new Password(email , hashedPassword);

        passwoedRep.save(passwordRecord);
    }

    public boolean checkPassword(String email , String password){
        Optional<Password> passwordRecord = passwoedRep.findById(email);

        return passwordManagement.checkPassword(password , passwordRecord.get().getHashedPassword());
    }
}
