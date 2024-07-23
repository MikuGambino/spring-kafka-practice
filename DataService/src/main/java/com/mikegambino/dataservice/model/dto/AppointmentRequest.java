package com.mikegambino.dataservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequest {
    private int doctorId;
    private int patientId;
    private BigDecimal price;
    private LocalDateTime appointmentTime;
}
