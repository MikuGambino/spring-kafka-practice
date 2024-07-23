package com.mikegambino.dataservice.repository;

import com.mikegambino.dataservice.model.Doctor;
import com.mikegambino.dataservice.model.util.DoctorAverageBill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface DoctorRepository extends ListCrudRepository<Doctor, Integer> {
    @Query("""
            select new com.mikegambino.dataservice.model.util.DoctorAverageBill(
                new com.mikegambino.dataservice.model.dto.DoctorResponse(
                    d.id,
                    d.surname,
                    d.name,
                    d.patronymic,
                    d.phone,
                    d.specialization
                ),
                cast(avg(ap.price) AS big_decimal) as averageBill
            )
            from Doctor d
            join Appointment ap on ap.doctor.id = d.id
            group by d.id
            order by averageBill desc
            limit 5
            """)
    List<DoctorAverageBill> findTop5DoctorsByAverageBill();
}
