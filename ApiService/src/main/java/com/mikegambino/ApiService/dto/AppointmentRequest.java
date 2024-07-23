package com.mikegambino.ApiService.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AppointmentRequest {
    @NotNull(message = "Patient id is null")
    @Min(value = 0, message = "Patient id less zero")
    private int patientId;
    @Min(value = 0, message = "Doctor id less zero")
    @NotNull(message = "Doctor id is null")
    private int doctorId;
    @NotNull(message = "Price is null")
    private BigDecimal price;
    private LocalDateTime appointmentTime;
}