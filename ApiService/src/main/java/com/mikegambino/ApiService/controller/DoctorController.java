package com.mikegambino.ApiService.controller;

import com.mikegambino.ApiService.dto.DoctorAverageBill;
import com.mikegambino.ApiService.dto.DoctorRequest;
import com.mikegambino.ApiService.dto.DoctorResponse;
import com.mikegambino.ApiService.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    private final DoctorService doctorService;
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<Void> addDoctor(@Valid @RequestBody DoctorRequest doctorRequest) {
        doctorService.addDoctor(doctorRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponse> getDoctor(@PathVariable int id) {
        return doctorService.getDoctor(id);
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponse>> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/top5ByAverageBill")
    public ResponseEntity<List<DoctorAverageBill>> getTop5DoctorsByAverageBill() {
        return doctorService.getTop5DoctorsByAverageBill();
    }
}
