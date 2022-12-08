package com.cvargas.dentalOffice.dentalOffice.repository;

import com.cvargas.dentalOffice.dentalOffice.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long> {
}
