package com.example.repository;

import com.example.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {

    public Absence findAbsenceById(Long id);


}
