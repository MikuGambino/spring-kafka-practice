package com.mikegambino.dataservice.model.mapper;

import com.mikegambino.dataservice.exceptions.ResourceNotFoundException;
import com.mikegambino.dataservice.model.Appointment;
import com.mikegambino.dataservice.model.Doctor;
import com.mikegambino.dataservice.model.Patient;
import com.mikegambino.dataservice.model.dto.AppointmentRequest;
import com.mikegambino.dataservice.model.dto.AppointmentResponse;
import com.mikegambino.dataservice.repository.DoctorRepository;
import com.mikegambino.dataservice.repository.PatientRepository;
import org.springframework.stereotype.Component;

import static com.mikegambino.dataservice.utils.AppConstants.*;

@Component
public class AppointmentMapper {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    public AppointmentMapper(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public Appointment toModel(AppointmentRequest appointmentDTO) {
        int doctorId = appointmentDTO.getDoctorId();
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(DOCTOR, ID, doctorId));

        int patientId = appointmentDTO.getPatientId();
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException(PATIENT, ID, patientId));

        return Appointment.builder()
                .patient(patient)
                .price(appointmentDTO.getPrice())
                .doctor(doctor)
                .appointmentTime(appointmentDTO.getAppointmentTime())
                .build();
    }

    public AppointmentResponse toResponse(Appointment appointment) {
        return AppointmentResponse.builder()
                .id(appointment.getId())
                .doctorId(appointment.getDoctor().getId())
                .patientId(appointment.getPatient().getId())
                .price(appointment.getPrice())
                .appointmentTime(appointment.getAppointmentTime())
                .build();
    }
}
