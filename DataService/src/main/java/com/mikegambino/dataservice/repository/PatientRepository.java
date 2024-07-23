package com.mikegambino.dataservice.repository;

import com.mikegambino.dataservice.model.Patient;
import com.mikegambino.dataservice.model.util.PatientVisitCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PatientRepository extends ListCrudRepository<Patient, Integer> {

    @Query("""
            select new com.mikegambino.dataservice.model.util.PatientVisitCount(
                new com.mikegambino.dataservice.model.dto.PatientResponse(
                        p.id,
                        p.surname,
                        p.name,
                        p.patronymic,
                        p.email,
                        p.gender,
                        p.birthday
                ),
                count(ap.id) as visitCount
            )
            from Patient p
            join Appointment ap on ap.patient.id = p.id
            group by p.id
            order by visitCount desc
            limit 5
            """)
    List<PatientVisitCount> findTop5PatientsByVisits();

}
