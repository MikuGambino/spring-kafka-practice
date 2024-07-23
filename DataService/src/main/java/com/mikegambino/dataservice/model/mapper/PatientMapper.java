package com.mikegambino.dataservice.model.mapper;

import com.mikegambino.dataservice.model.Patient;
import com.mikegambino.dataservice.model.dto.PatientRequest;
import com.mikegambino.dataservice.model.dto.PatientResponse;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient toModel(PatientRequest patientRequest) {
        return Patient.builder()
                .name(patientRequest.getName())
                .surname(patientRequest.getSurname())
                .patronymic(patientRequest.getPatronymic())
                .gender(patientRequest.getGender())
                .birthday(patientRequest.getBirthday())
                .email(patientRequest.getEmail())
                .build();
    }

    public PatientResponse toResponse(Patient patient) {
        return PatientResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .surname(patient.getSurname())
                .patronymic(patient.getPatronymic())
                .gender(patient.getGender())
                .birthday(patient.getBirthday())
                .email(patient.getEmail())
                .build();
    }
}
