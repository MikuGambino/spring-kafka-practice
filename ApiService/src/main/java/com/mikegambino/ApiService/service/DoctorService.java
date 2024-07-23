package com.mikegambino.ApiService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikegambino.ApiService.dto.DoctorAverageBill;
import com.mikegambino.ApiService.dto.DoctorRequest;
import com.mikegambino.ApiService.dto.DoctorResponse;
import com.mikegambino.ApiService.util.RestTemplateGetter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final RestTemplateGetter restTemplateGetter;
    @Value("${dataService.url}/doctors")
    private String dataServiceUrl;

    public DoctorService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper, RestTemplateGetter restTemplateGetter) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
        this.restTemplateGetter = restTemplateGetter;
    }

    @SneakyThrows
    public void addDoctor(DoctorRequest doctorRequest) {
        String doctorString = objectMapper.writeValueAsString(doctorRequest);
        kafkaTemplate.send("doctors", doctorString);
    }

    public ResponseEntity<List<DoctorAverageBill>> getTop5DoctorsByAverageBill() {
        return restTemplateGetter.requestList(dataServiceUrl + "/top5ByAverageBill", DoctorAverageBill.class);
    }

    public ResponseEntity<DoctorResponse> getDoctor(int id) {
        return restTemplateGetter.request(dataServiceUrl + "/" + id, DoctorResponse.class);
    }

    public ResponseEntity<List<DoctorResponse>> getAllDoctors() {
        return restTemplateGetter.requestList(dataServiceUrl, DoctorResponse.class);
    }
}
