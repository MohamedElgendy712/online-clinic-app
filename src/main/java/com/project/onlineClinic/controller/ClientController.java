package com.project.onlineClinic.controller;


import com.project.onlineClinic.dto.ChangeAppointmentStatusDTO;
import com.project.onlineClinic.dto.ResponseDTO;
import com.project.onlineClinic.entity.Review;
import com.project.onlineClinic.entity.Appointment;
import com.project.onlineClinic.entity.User;
import com.project.onlineClinic.service.ClientServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
@CrossOrigin
public class ClientController {
    @Autowired
    private ClientServ clientServ;

    @Autowired
    ResponseDTO response;

    @GetMapping("getUserInfo/{email}")
    public User getUser(@PathVariable String email){
        return clientServ.getUserInfo(email);
    }

    @GetMapping("getAllSpecialization")
    public List<Object[]> getAllSpecialization(){
        return clientServ.findAllSpecialization();
    }

    @GetMapping("getAllDoctorForSpec/{specialization}")
    public List<Object[]> getAllDoctorForSpecialization(@PathVariable String specialization){
        return clientServ.findAllDoctorForSpecialization(specialization);
    }

    @GetMapping("getDoctorById/{id}")
    public User getDoctorById(@PathVariable int id){
        return clientServ.findDoctorById(id);
    }

    @GetMapping("getAllReviewsForDoctor/{id}")
    public List<Review> getReviewsByDoctorId(@PathVariable int id){
        return clientServ.findReviewsByDoctorId(id);
    }

    @PostMapping("addReview")
    public ResponseEntity<ResponseDTO> addReview(@RequestBody Review review){
        clientServ.addReview(review);
        return new ResponseEntity<>(response , response.getCode());
    }

    @PostMapping("bookAppointment")
    public ResponseEntity<ResponseDTO> bookAppointment(@RequestBody Appointment appointment){
        clientServ.bookAppointment(appointment);

        return new ResponseEntity<>(response , response.getCode());
    }

    @GetMapping("getAllAppointmentForPatient/{id}")
    public List<Appointment> getAllAppointmentForPatient(@PathVariable int id){
        return clientServ.getAllAppointmentForPatient(id);
    }

    @GetMapping("getAppointmentsHistoryForPatient/{id}")
    public List<Appointment> getAppointmentsHistoryForPatient(@PathVariable int id){
        return clientServ.getAppointmentsHistoryForPatient(id);
    }

    @GetMapping("getAllAppointmentForDoctor/{id}")
    public List<Appointment> getAllAppointmentForDoctor(@PathVariable int id){
        return clientServ.getAllAppointmentForDoctor(id);
    }

    @GetMapping("getAppointmentsHistoryForDoctor/{id}")
    public List<Appointment> getAppointmentsHistoryForDoctor(@PathVariable int id){
        return clientServ.getAppointmentsHistoryForDoctor(id);
    }

    @PutMapping("updateAppointmentStatus")
    public ResponseEntity<ResponseDTO> updateAppointmentStatus(@RequestBody ChangeAppointmentStatusDTO request){
        clientServ.updateAppointmentStatus(request);

        return new ResponseEntity<>(response , response.getCode());
    }

}
