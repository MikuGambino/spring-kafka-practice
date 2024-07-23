package com.mikegambino.dataservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DoctorResponse {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String phone;
    private String specialization;
}
