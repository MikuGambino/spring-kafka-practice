package com.mikegambino.ApiService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class DoctorAverageBill {
    private DoctorResponse doctorResponse;
    private BigDecimal averageBill;
}
