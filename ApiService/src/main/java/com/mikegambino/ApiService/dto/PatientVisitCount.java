package com.mikegambino.ApiService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientVisitCount {
    private PatientResponse patientResponse;
    private int visitCount;

    public PatientVisitCount(PatientResponse patientResponse, Long visitCount) {
        this.patientResponse = patientResponse;
        this.visitCount = visitCount.intValue();
    }
}
