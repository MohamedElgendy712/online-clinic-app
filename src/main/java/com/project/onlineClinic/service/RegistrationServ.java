package com.project.onlineClinic.service;

import com.project.onlineClinic.dto.ResponseDTO;
import com.project.onlineClinic.dto.UserInfoDTO;
import com.project.onlineClinic.entity.User;
import com.project.onlineClinic.entity.Password;
import com.project.onlineClinic.repository.UserRep;
import com.project.onlineClinic.repository.PasswoedRep;
import com.project.onlineClinic.utility.PasswordManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationServ {

    @Autowired
    private UserRep userRep;
    @Autowired
    private PasswoedRep passwoedRep;
    @Autowired
    private PasswordManagement passwordManagement;
    @Autowired
    private ResponseDTO response;

    public void registerUser(UserInfoDTO userInfo){


        User user = new User(userInfo.getFirstName(),userInfo.getLastName(),userInfo.getGender()
                                    ,userInfo.getEmail(),userInfo.getPhone(),userInfo.getBirthDate()
                                    ,userInfo.getSpecialization(),userInfo.getExperience(),userInfo.isDoctor());

        try{
            userRep.save(user);
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

        savePassword(userInfo.getEmail() , userInfo.getPassword());

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
