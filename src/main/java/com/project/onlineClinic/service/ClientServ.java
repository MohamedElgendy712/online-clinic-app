package com.project.onlineClinic.service;


import com.project.onlineClinic.dto.ChangeAppointmentStatusDTO;
import com.project.onlineClinic.dto.ResponseDTO;
import com.project.onlineClinic.entity.Review;
import com.project.onlineClinic.entity.Appointment;
import com.project.onlineClinic.entity.User;
import com.project.onlineClinic.repository.AppointmentRep;
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

    @Autowired
    AppointmentRep appointmentRep;

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

    public void bookAppointment(Appointment appointment){

        Appointment a = new Appointment(appointment.getPatient() , appointment.getDoctor() , appointment.getAppointmentDate() , appointment.getAppointmentSpecialization() , appointment.getAppointmentStatus());
        appointmentRep.save(a);

        response.setCode(HttpStatus.OK);
        response.setMessage("Appointment is booked successfully");
    }

    public List<Appointment> getAllAppointmentForPatient(int id){
        return appointmentRep.getAllAppointmentForPatient(id);
    }

    public List<Appointment> getAppointmentsHistoryForPatient(int id){
        return appointmentRep.getAppointmentsHistoryForPatient(id);
    }

    public List<Appointment> getAllAppointmentForDoctor(int id){
        return appointmentRep.getAllAppointmentForDoctor(id);
    }

    public List<Appointment> getAppointmentsHistoryForDoctor(int id){
        return appointmentRep.getAppointmentsHistoryForDoctor(id);
    }

    public void updateAppointmentStatus(ChangeAppointmentStatusDTO request){
        appointmentRep.updateAppointmentStatus(request.getId(),request.getStatus());

        response.setCode(HttpStatus.OK);
        response.setMessage("Appointment is updated successfully");
    }
}
