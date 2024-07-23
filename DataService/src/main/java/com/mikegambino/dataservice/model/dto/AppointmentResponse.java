package com.mikegambino.dataservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class AppointmentResponse {
    private int id;
    private int patientId;
    private int doctorId;
    private BigDecimal price;
    private LocalDateTime appointmentTime;
}
