package com.mikegambino.dataservice.model.mapper;

import com.mikegambino.dataservice.model.Doctor;
import com.mikegambino.dataservice.model.dto.DoctorRequest;
import com.mikegambino.dataservice.model.dto.DoctorResponse;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public Doctor toModel(DoctorRequest doctorRequest) {
        return Doctor.builder()
                .name(doctorRequest.getName())
                .surname(doctorRequest.getSurname())
                .patronymic(doctorRequest.getPatronymic())
                .specialization(doctorRequest.getSpecialization())
                .phone(doctorRequest.getPhone())
                .build();
    }

    public DoctorResponse toResponse(Doctor doctor) {
        return DoctorResponse.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .surname(doctor.getSurname())
                .patronymic(doctor.getPatronymic())
                .phone(doctor.getPhone())
                .specialization(doctor.getSpecialization())
                .build();
    }
}
