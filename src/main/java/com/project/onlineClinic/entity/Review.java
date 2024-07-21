package com.project.onlineClinic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reviews")
public class Review {

    @Id
    private int reviewId;
    @ManyToOne
    @JoinColumn(name = "doctorId" , referencedColumnName = "userId", nullable = false)
    private User doctor;
    private String reviewerName;
    private float rating;
    private String review;
    private Date reviewDate;

}
