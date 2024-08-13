package com.project.onlineClinic.controller;

import com.project.onlineClinic.dto.LoginDTO;
import com.project.onlineClinic.dto.ResponseDTO;
import com.project.onlineClinic.dto.UserInfoDTO;
import com.project.onlineClinic.service.ClientServ;
import com.project.onlineClinic.service.RegistrationServ;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/registrationLogin/")
@CrossOrigin(origins = "http://localhost:4200" , allowCredentials = "true")
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
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginDTO , HttpServletRequest request){
        registrationServ.checkPassword(loginDTO.getEmail() , loginDTO.getPassword());
        HttpSession session = request.getSession();

        if(response.getCode() == HttpStatus.OK)
            session.setAttribute("sessionId" , loginDTO.getEmail());

        return new ResponseEntity<>(response, response.getCode());
    }

}
