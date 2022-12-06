package com.cvargas.dentalOffice.dentalOffice.repository;

import com.cvargas.dentalOffice.dentalOffice.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
