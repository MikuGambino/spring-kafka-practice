package com.mikegambino.ApiService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikegambino.ApiService.dto.PatientRequest;
import com.mikegambino.ApiService.dto.PatientResponse;
import com.mikegambino.ApiService.dto.PatientVisitCount;
import com.mikegambino.ApiService.util.RestTemplateGetter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final RestTemplateGetter restTemplateGetter;
    @Value("${dataService.url}/patients")
    private String dataServiceURL;

    public PatientService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper, RestTemplateGetter restTemplateGetter) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
        this.restTemplateGetter = restTemplateGetter;
    }

    @SneakyThrows
    public void addPatient(PatientRequest patientRequest) {
        String patientString = objectMapper.writeValueAsString(patientRequest);
        kafkaTemplate.send("patients", patientString);
    }

    public ResponseEntity<PatientResponse> getPatient(int id) {
        return restTemplateGetter.request(dataServiceURL + "/" + id, PatientResponse.class);
    }

    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        return restTemplateGetter.requestList(dataServiceURL, PatientResponse.class);
    }

    public ResponseEntity<List<PatientVisitCount>> getTop5PatientByVisitCount() {
        return restTemplateGetter.requestList(dataServiceURL + "/top5ByVisitCount", PatientVisitCount.class);
    }
}
