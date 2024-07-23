package com.mikegambino.dataservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikegambino.dataservice.exceptions.ResourceNotFoundException;
import com.mikegambino.dataservice.model.Patient;
import com.mikegambino.dataservice.model.dto.PatientRequest;
import com.mikegambino.dataservice.model.dto.PatientResponse;
import com.mikegambino.dataservice.model.mapper.PatientMapper;
import com.mikegambino.dataservice.model.util.PatientVisitCount;
import com.mikegambino.dataservice.repository.PatientRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mikegambino.dataservice.utils.AppConstants.ID;
import static com.mikegambino.dataservice.utils.AppConstants.PATIENT;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final ObjectMapper objectMapper;
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, ObjectMapper objectMapper, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.objectMapper = objectMapper;
        this.patientMapper = patientMapper;
    }

    public PatientResponse getPatient(int id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(PATIENT, ID, id));

        return patientMapper.toResponse(patient);
    }

    public List<PatientResponse> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(patientMapper::toResponse)
                .toList();
    }

    @SneakyThrows
    public void addPatient(String data) {
        PatientRequest patientRequest = objectMapper.readValue(data, PatientRequest.class);

        Patient patient = patientMapper.toModel(patientRequest);

        patientRepository.save(patient);
    }

    public List<PatientVisitCount> getTop5PatientsByVisitCount() {
        return patientRepository.findTop5PatientsByVisits();
    }
}
