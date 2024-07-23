package com.mikegambino.ApiService.controller;

import com.mikegambino.ApiService.dto.AppointmentRequest;
import com.mikegambino.ApiService.dto.AppointmentResponse;
import com.mikegambino.ApiService.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Void> addAppointment(@Valid @RequestBody AppointmentRequest appointmentRequest) {
        appointmentService.addAppointment(appointmentRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> getAppointment(@PathVariable int id) {
        return appointmentService.getAppointment(id);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAllResponses() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/top5ByPrice")
    public ResponseEntity<List<AppointmentResponse>> getTop5AppointmentsByPrice() {
        return appointmentService.getTop5AppointmentsByPrice();
    }
}
