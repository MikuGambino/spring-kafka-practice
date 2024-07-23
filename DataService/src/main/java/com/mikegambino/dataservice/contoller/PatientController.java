package com.mikegambino.dataservice.contoller;

import com.mikegambino.dataservice.model.dto.PatientResponse;
import com.mikegambino.dataservice.model.util.PatientVisitCount;
import com.mikegambino.dataservice.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatient(@PathVariable("id") int id) {
        PatientResponse patient = patientService.getPatient(id);

        return ResponseEntity.ok(patient);
    }

    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        List<PatientResponse> patients = patientService.getAllPatients();

        return ResponseEntity.ok(patients);
    }

    @GetMapping("/top5ByVisitCount")
    public ResponseEntity<List<PatientVisitCount>> getTop5PatientByVisitCount() {
        List<PatientVisitCount> patients = patientService.getTop5PatientsByVisitCount();

        return ResponseEntity.ok(patients);
    }
}
