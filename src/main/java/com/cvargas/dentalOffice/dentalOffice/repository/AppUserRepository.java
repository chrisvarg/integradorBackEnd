package com.cvargas.dentalOffice.dentalOffice.repository;

import com.cvargas.dentalOffice.dentalOffice.model.login.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly=true)
public interface AppUserRepository extends JpaRepository<UserApp, Long> {
    Optional<UserApp> findByEmail(String email);
}
