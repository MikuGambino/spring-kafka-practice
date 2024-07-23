package com.mikegambino.dataservice.listener;

import com.mikegambino.dataservice.service.AppointmentService;
import com.mikegambino.dataservice.service.DoctorService;
import com.mikegambino.dataservice.service.PatientService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    private final PatientService patientService;
    private final DoctorService doctorService;
    private final AppointmentService appointmentService;

    public KafkaListeners(PatientService patientService, DoctorService doctorService, AppointmentService appointmentService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
    }

    @KafkaListener(topics = "patients")
    public void patientListener(String data) {
        System.out.println("Message received: " + data);
        patientService.addPatient(data);
    }

    @KafkaListener(topics = "doctors")
    public void doctorListener(String data) {
        System.out.println("Message received: " + data);
        doctorService.addDoctor(data);
    }

    @KafkaListener(topics = "appointments")
    public void appointmentListener(String data) {
        System.out.println("Message received: " + data);
        appointmentService.addAppointment(data);
    }

}
