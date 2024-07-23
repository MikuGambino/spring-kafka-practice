package com.mikegambino.dataservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikegambino.dataservice.exceptions.ResourceNotFoundException;
import com.mikegambino.dataservice.model.Doctor;
import com.mikegambino.dataservice.model.dto.DoctorRequest;
import com.mikegambino.dataservice.model.dto.DoctorResponse;
import com.mikegambino.dataservice.model.mapper.DoctorMapper;
import com.mikegambino.dataservice.model.util.DoctorAverageBill;
import com.mikegambino.dataservice.repository.DoctorRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mikegambino.dataservice.utils.AppConstants.DOCTOR;
import static com.mikegambino.dataservice.utils.AppConstants.ID;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final ObjectMapper objectMapper;
    private final DoctorMapper doctorMapper;

    public DoctorService(DoctorRepository doctorRepository, ObjectMapper objectMapper, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.objectMapper = objectMapper;
        this.doctorMapper = doctorMapper;
    }

    public DoctorResponse getDoctor(int id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(DOCTOR, ID, id));

        return doctorMapper.toResponse(doctor);
    }
    public List<DoctorResponse> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();

        return doctors.stream()
                .map(doctorMapper::toResponse)
                .toList();
    }
    @SneakyThrows
    public void addDoctor(String data) {
        DoctorRequest doctorRequest = objectMapper.readValue(data, DoctorRequest.class);

        Doctor doctor = doctorMapper.toModel(doctorRequest);

        doctorRepository.save(doctor);
    }

    public List<DoctorAverageBill> getTop5DoctorsByAverageBill() {
        return doctorRepository.findTop5DoctorsByAverageBill();
    }
}
