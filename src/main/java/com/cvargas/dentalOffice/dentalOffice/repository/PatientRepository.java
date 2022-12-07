package com.cvargas.dentalOffice.dentalOffice.repository;

import com.cvargas.dentalOffice.dentalOffice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
