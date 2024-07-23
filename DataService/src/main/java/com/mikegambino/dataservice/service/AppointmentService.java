package com.mikegambino.dataservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikegambino.dataservice.exceptions.ResourceNotFoundException;
import com.mikegambino.dataservice.model.Appointment;
import com.mikegambino.dataservice.model.dto.AppointmentRequest;
import com.mikegambino.dataservice.model.dto.AppointmentResponse;
import com.mikegambino.dataservice.model.mapper.AppointmentMapper;
import com.mikegambino.dataservice.repository.AppointmentRepository;
import com.mikegambino.dataservice.repository.DoctorRepository;
import com.mikegambino.dataservice.repository.PatientRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.mikegambino.dataservice.utils.AppConstants.APPOINTMENT;
import static com.mikegambino.dataservice.utils.AppConstants.ID;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final ObjectMapper objectMapper;
    private final AppointmentMapper appointmentMapper;

    public AppointmentService(AppointmentRepository appointmentRepository, ObjectMapper objectMapper, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.objectMapper = objectMapper;
        this.appointmentMapper = appointmentMapper;
    }

    public AppointmentResponse getAppointment(int id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(APPOINTMENT, ID, id));

        return appointmentMapper.toResponse(appointment);
    }

    public List<AppointmentResponse> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();

        return appointments.stream()
                .map(appointmentMapper::toResponse)
                .toList();
    }

    @SneakyThrows
    public void addAppointment(String data) {
        AppointmentRequest appointmentDTO = objectMapper.readValue(data, AppointmentRequest.class);

        Appointment appointment = appointmentMapper.toModel(appointmentDTO);

        if (appointment.getAppointmentTime() == null) {
            appointment.setAppointmentTime(LocalDateTime.now());
        }

        appointmentRepository.save(appointment);
    }

    public List<AppointmentResponse> getTop5AppointmentsByPrice() {
        return appointmentRepository.findTop5AppointmentsByPrice();
    }
}
