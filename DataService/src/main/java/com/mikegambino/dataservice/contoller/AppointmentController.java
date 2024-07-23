package com.mikegambino.dataservice.contoller;

import com.mikegambino.dataservice.model.dto.AppointmentResponse;
import com.mikegambino.dataservice.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> getAppointment(@PathVariable("id") int id) {
        AppointmentResponse response = appointmentService.getAppointment(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments() {
        List<AppointmentResponse> responses = appointmentService.getAllAppointments();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/top5ByPrice")
    public ResponseEntity<List<AppointmentResponse>> top5AppointmentsByPrice() {
        List<AppointmentResponse> responses = appointmentService.getTop5AppointmentsByPrice();

        return ResponseEntity.ok(responses);
    }
}
