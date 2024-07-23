package com.mikegambino.ApiService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    private int id;
    private int patientId;
    private int doctorId;
    private BigDecimal price;
    private LocalDateTime appointmentTime;
}
