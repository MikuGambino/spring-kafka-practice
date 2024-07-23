package com.mikegambino.ApiService.controller;

import com.mikegambino.ApiService.dto.PatientRequest;
import com.mikegambino.ApiService.dto.PatientResponse;
import com.mikegambino.ApiService.dto.PatientVisitCount;
import com.mikegambino.ApiService.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/patients")
@RestController
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Void> addPatient(@Valid @RequestBody PatientRequest patientRequest) {
        patientService.addPatient(patientRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatient(@PathVariable int id) {
        return patientService.getPatient(id);
    }

    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/top5ByVisitCount")
    public ResponseEntity<List<PatientVisitCount>> getTop5PatientByVisitCount() {
        return patientService.getTop5PatientByVisitCount();
    }
}
