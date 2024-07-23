package com.mikegambino.ApiService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String phone;
    private String specialization;
}
