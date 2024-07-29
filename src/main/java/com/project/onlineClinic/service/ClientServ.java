package com.project.onlineClinic.service;


import com.project.onlineClinic.dto.ResponseDTO;
import com.project.onlineClinic.entity.Review;
import com.project.onlineClinic.entity.User;
import com.project.onlineClinic.repository.ReviewRep;
import com.project.onlineClinic.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServ {
    @Autowired
    UserRep userRep;

    @Autowired
    ReviewRep reviewRep;

    @Autowired
    ResponseDTO response;

    public User getUserInfo(String email){
        return userRep.findByEmail(email);
    }
    public List<Object[]> findAllSpecialization(){
        return userRep.findAllSpecialization();
    }

    public List<Object[]> findAllDoctorForSpecialization(String specialization){
        return reviewRep.findAllDoctorForSpecialization(specialization);
    }

    public User findDoctorById(int id){
        return userRep.findById(id);
    }


    public List<Review> findReviewsByDoctorId(int id){
        return reviewRep.findReviewsByDoctorId(id);
    }

    public void addReview(Review review){

        Review r = new Review(review.getDoctor(),review.getReviewerName(),review.getRating(),review.getReview(),review.getReviewDate());
        reviewRep.save(r);

        response.setCode(HttpStatus.OK);
        response.setMessage("Review created successfully");
    }

}
