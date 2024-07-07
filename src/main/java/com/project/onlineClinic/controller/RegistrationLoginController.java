package com.project.onlineClinic.controller;

import com.project.onlineClinic.dto.LoginDTO;
import com.project.onlineClinic.dto.ResponseDTO;
import com.project.onlineClinic.dto.UserInfoDTO;
import com.project.onlineClinic.service.RegistrationServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/registrationLogin/")
public class RegistrationLoginController {

    @Autowired
    RegistrationServ registrationServ;

    @PostMapping(path = "register")
    public ResponseEntity<ResponseDTO> register(@RequestBody UserInfoDTO userInfo){

        if(registrationServ.registerUser(userInfo)){
            ResponseDTO response = new ResponseDTO("I000000" , "User created successfully");
            return new ResponseEntity<>(response , HttpStatus.OK);
        }
        else {
            ResponseDTO response = new ResponseDTO("E999999" , "Internal Server Error");
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginDTO){
        if(registrationServ.checkPassword(loginDTO.getEmail() , loginDTO.getPassword())) {
            ResponseDTO response = new ResponseDTO("I000000", "User login successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            ResponseDTO response = new ResponseDTO("E999999" , "Internal Server Error");
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
