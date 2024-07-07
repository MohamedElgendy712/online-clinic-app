package com.project.onlineClinic.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordManagement {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String generateSaltedHash(String password){
        return passwordEncoder.encode(password);
    }

    public boolean checkPassword(String password , String hashedPassword){
        return passwordEncoder.matches(password , hashedPassword);
    }
}
