package com.mikegambino.dataservice.repository;

import com.mikegambino.dataservice.model.Appointment;
import com.mikegambino.dataservice.model.dto.AppointmentResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface AppointmentRepository extends ListCrudRepository<Appointment, Integer> {
    @Query("""
            select new com.mikegambino.dataservice.model.dto.AppointmentResponse(
                a.id,
                a.doctor.id,
                a.patient.id,
                a.price,
                a.appointmentTime
            )
            from Appointment a
            order by price desc
            limit 5
            """)
    List<AppointmentResponse> findTop5AppointmentsByPrice();
}
