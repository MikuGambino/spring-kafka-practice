package com.mikegambino.ApiService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String email;
    private String gender;
    private LocalDate birthday;
}