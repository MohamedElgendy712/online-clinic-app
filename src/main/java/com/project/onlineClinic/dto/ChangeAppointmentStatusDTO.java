package com.project.onlineClinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeAppointmentStatusDTO {

    private int id;
    private String status;
}
