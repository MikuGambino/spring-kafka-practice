package com.mikegambino.ApiService.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequest {
    @NotBlank(message = "Surname is blank")
    private String surname;
    @NotBlank(message = "Name is blank")
    private String name;
    private String patronymic;
    @NotBlank(message = "Email is blank")
    private String email;
    private String gender;
    private LocalDate birthday;
}