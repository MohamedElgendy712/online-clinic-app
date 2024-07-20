package com.project.onlineClinic.controller;

import com.project.onlineClinic.dto.LoginDTO;
import com.project.onlineClinic.dto.ResponseDTO;
import com.project.onlineClinic.dto.UserInfoDTO;
import com.project.onlineClinic.service.ClientServ;
import com.project.onlineClinic.service.RegistrationServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginDTO){
        registrationServ.checkPassword(loginDTO.getEmail() , loginDTO.getPassword());

        return new ResponseEntity<>(response, response.getCode());
    }

}
