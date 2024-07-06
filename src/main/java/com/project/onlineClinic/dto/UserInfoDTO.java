package com.project.onlineClinic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoDTO {
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phone;
    @JsonProperty("bod")
    private String birthDate;
    private String specialization;
    @JsonProperty
    private boolean isDoctor;
    private int experience;
    private String password;

    public boolean isDoctor() {
        return isDoctor;
    }
}
