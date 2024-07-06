package com.project.onlineClinic.controller;

import com.project.onlineClinic.dto.UserInfoDTO;
import com.project.onlineClinic.service.RegistrationServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/registrationLogin/")
public class RegistrationLoginController {

    @Autowired
    RegistrationServ registrationServ;

    @PostMapping(path = "register")
    public ResponseEntity.BodyBuilder register(@RequestBody UserInfoDTO userInfo){

        if(registrationServ.registerUser(userInfo)){
            return ResponseEntity.ok();
        }
        else {
            return ResponseEntity.badRequest();
        }
    }
}
