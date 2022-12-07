package com.cvargas.dentalOffice.dentalOffice.repository;

import com.cvargas.dentalOffice.dentalOffice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
