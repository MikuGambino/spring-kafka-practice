package com.mikegambino.dataservice.contoller;

import com.mikegambino.dataservice.model.dto.DoctorResponse;
import com.mikegambino.dataservice.model.util.DoctorAverageBill;
import com.mikegambino.dataservice.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponse> getDoctor(@PathVariable("id") int id) {
        DoctorResponse response = doctorService.getDoctor(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponse>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/top5ByAverageBill")
    public ResponseEntity<List<DoctorAverageBill>> getTop5DoctorsByAverageBill() {
        List<DoctorAverageBill> doctors = doctorService.getTop5DoctorsByAverageBill();

        return ResponseEntity.ok(doctors);
    }
}
