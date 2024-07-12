package com.project.onlineClinic.service;

import java.sql.*;

import com.project.onlineClinic.dto.ResponseDTO;
import com.project.onlineClinic.dto.UserInfoDTO;
import com.project.onlineClinic.entity.Doctor;
import com.project.onlineClinic.entity.Password;
import com.project.onlineClinic.entity.Patient;
import com.project.onlineClinic.repository.DoctorRep;
import com.project.onlineClinic.repository.PasswoedRep;
import com.project.onlineClinic.repository.PatientRep;
import com.project.onlineClinic.utility.PasswordManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private ResponseDTO response;

    public void registerUser(UserInfoDTO user){

        if(user.isDoctor()){
            Doctor doctor = new Doctor(user.getFirstName(),user.getLastName(),user.getGender()
                                        ,user.getEmail(),user.getPhone(),user.getBirthDate()
                                        ,user.getSpecialization(),user.getExperience());

            try{
                doctorRep.save(doctor);
                response.setCode(HttpStatus.OK);
                response.setMessage("User created successfully");

            }catch (DataIntegrityViolationException e){
                response.setCode(HttpStatus.BAD_REQUEST);
                response.setMessage("The entered email already exist");
                return;
            }catch (Exception e){
                response.setCode(HttpStatus.NOT_FOUND);
                response.setMessage("Please try again");
                return;
            }

        }
        else{

            Patient patient = new Patient(user.getFirstName(),user.getLastName(),user.getGender()
                    ,user.getEmail(),user.getPhone(),user.getBirthDate());

            try{
                patientRep.save(patient);
                response.setCode(HttpStatus.OK);
                response.setMessage("User created successfully");

            }catch (DataIntegrityViolationException e){
                response.setCode(HttpStatus.BAD_REQUEST);
                response.setMessage("The entered email already exists");
                return;
            }catch (Exception e){
                response.setCode(HttpStatus.NOT_FOUND);
                response.setMessage("Please try again");
                return;
            }
        }

        savePassword(user.getEmail() , user.getPassword());

    }

    public void savePassword(String email , String password){
        String hashedPassword = passwordManagement.generateSaltedHash(password);

        Password passwordRecord = new Password(email , hashedPassword);

        passwoedRep.save(passwordRecord);
    }

    public void checkPassword(String email , String password){
        Optional<Password> passwordRecord = passwoedRep.findById(email);

        if (!passwordRecord.isPresent()){
            response.setCode(HttpStatus.BAD_REQUEST);
            response.setMessage("Email is not found");
        }else if(!(passwordManagement.checkPassword(password , passwordRecord.get().getHashedPassword()))){
            response.setCode(HttpStatus.BAD_REQUEST);
            response.setMessage("Password is incorrect");
        }else{
            response.setCode(HttpStatus.OK);
            response.setMessage("User login successfully");
        }
    }
}
