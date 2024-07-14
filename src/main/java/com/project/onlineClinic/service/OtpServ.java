package com.project.onlineClinic.service;

import com.project.onlineClinic.dto.ResponseDTO;
import com.project.onlineClinic.entity.OTP;
import com.project.onlineClinic.repository.OtpRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpServ {

    @Autowired
    private OtpRep otpRep;
    @Autowired
    private ResponseDTO response;
    @Autowired
    EmailSenderServ emailSenderServ;

    public OTP generate(String email){

        OTP otp = new OTP();

        otp.setOtpNo(generateOtpNum());
        otp.setCreationDate(new Date());
        otpRep.save(otp);

        emailSenderServ.sendEmail(email,"Login OTP", String.valueOf(otp.getOtpNo()));
        return otp;
    }

    public int generateOtpNum(){
        Random random = new Random();
        return random.nextInt(1000 , 9999);
    }

    public void validateOTP(OTP otpObj){
        Optional<OTP> otp = otpRep.findById(otpObj.getOtpId());
        Date currDate = new Date();

        if (currDate.getTime() - otp.get().getCreationDate().getTime() > 300000){
            response.setCode(HttpStatus.BAD_REQUEST);
            response.setMessage("The entered OTP is expired");
        }else if (otp.get().getOtpNo() == otpObj.getOtpNo()){
            response.setCode(HttpStatus.OK);
            response.setMessage("OTP is validated");
        }else{
            response.setCode(HttpStatus.BAD_REQUEST);
            response.setMessage("The entered OTP is invalid");
        }

    }

}
