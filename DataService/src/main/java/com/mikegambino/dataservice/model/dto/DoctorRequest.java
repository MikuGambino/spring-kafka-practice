package com.mikegambino.dataservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorRequest {
    private String surname;
    private String name;
    private String patronymic;
    private String phone;
    private String specialization;
}
