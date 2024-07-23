package com.mikegambino.ApiService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikegambino.ApiService.dto.AppointmentRequest;
import com.mikegambino.ApiService.dto.AppointmentResponse;
import com.mikegambino.ApiService.util.RestTemplateGetter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final RestTemplateGetter restTemplateGetter;

    @Value("${dataService.url}/appointments")
    private String dataServiceURL;

    public AppointmentService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper, RestTemplateGetter restTemplateGetter) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
        this.restTemplateGetter = restTemplateGetter;
    }

    @SneakyThrows
    public void addAppointment(AppointmentRequest appointmentRequest) {
        String appointmentString = objectMapper.writeValueAsString(appointmentRequest);
        kafkaTemplate.send("appointments", appointmentString);
    }

    public ResponseEntity<AppointmentResponse> getAppointment(int id) {
        return restTemplateGetter.request(dataServiceURL + "/" + id, AppointmentResponse.class);
    }

    public ResponseEntity<List<AppointmentResponse>> getAllAppointments() {
        return restTemplateGetter.requestList(dataServiceURL, AppointmentResponse.class);
    }

    public ResponseEntity<List<AppointmentResponse>> getTop5AppointmentsByPrice() {
        return restTemplateGetter.requestList(dataServiceURL + "/top5ByPrice", AppointmentResponse.class);
    }
}