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
@CrossOrigin
public class RegistrationLoginController {

    @Autowired
    RegistrationServ registrationServ;
    @Autowired
    ResponseDTO response;

    @PostMapping(path = "register")
    public ResponseEntity<ResponseDTO> register(@RequestBody UserInfoDTO userInfo){
        registrationServ.registerUser(userInfo);

        return new ResponseEntity<>(response, response.getCode());
    }

    @PostMapping(path = "login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        registrationServ.checkPassword(loginDTO.getEmail() , loginDTO.getPassword());

        return new ResponseEntity<>(response.getMessage(), response.getCode());
    }

}
