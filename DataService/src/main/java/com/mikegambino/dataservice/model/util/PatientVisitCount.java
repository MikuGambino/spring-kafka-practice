package com.mikegambino.dataservice.model.util;

import com.mikegambino.dataservice.model.dto.PatientResponse;
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
