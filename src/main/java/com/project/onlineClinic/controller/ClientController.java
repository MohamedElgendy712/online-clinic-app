package com.project.onlineClinic.controller;

import com.project.onlineClinic.entity.User;
import com.project.onlineClinic.service.ClientServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientServ clientServ;

    @GetMapping("getUserInfo/:email")
    public User getUser(@PathVariable String email){
        return clientServ.getUserInfo(email);
    }
}