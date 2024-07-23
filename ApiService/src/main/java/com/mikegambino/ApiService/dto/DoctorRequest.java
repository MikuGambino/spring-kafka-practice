package com.mikegambino.ApiService.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DoctorRequest {
    @NotBlank(message = "Surname is blank")
    private String surname;
    @NotBlank(message = "Name is blank")
    private String name;
    private String patronymic;
    @NotBlank(message = "Phone is blank")
    private String phone;
    private String specialization;
}
