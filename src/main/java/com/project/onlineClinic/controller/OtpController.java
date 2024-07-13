package com.project.onlineClinic.controller;

import com.project.onlineClinic.dto.OtpRequestDTO;
import com.project.onlineClinic.dto.ResponseDTO;
import com.project.onlineClinic.entity.OTP;
import com.project.onlineClinic.service.OtpServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("otp")
@CrossOrigin
public class OtpController {
    @Autowired
    private OtpServ otpServ;
    @Autowired
    private ResponseDTO response;



    @PostMapping("generate")
    public ResponseEntity<OTP> generateOTP(@RequestBody OtpRequestDTO otpRequestDTO){
        OTP otp = otpServ.generate(otpRequestDTO.getEmail());

        return new ResponseEntity<>(otp , HttpStatus.OK);
    }

    @PostMapping("check")
    public ResponseEntity<ResponseDTO> checkOTP(@RequestBody OTP otp){

        otpServ.validateOTP(otp);

        return new ResponseEntity<>(response , response.getCode());
    }
}
