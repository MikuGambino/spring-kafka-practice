package com.mikegambino.dataservice.model.util;

import com.mikegambino.dataservice.model.dto.DoctorResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class DoctorAverageBill {
    private DoctorResponse doctorResponse;
    private BigDecimal averageBill;
}
