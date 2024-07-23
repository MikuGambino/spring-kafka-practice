package com.mikegambino.dataservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class PatientResponse {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String email;
    private String gender;
    private LocalDate birthday;
}