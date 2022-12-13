package com.cvargas.dentalOffice.dentalOffice.config;

import com.cvargas.dentalOffice.dentalOffice.model.login.AppUserRol;
import com.cvargas.dentalOffice.dentalOffice.model.login.UserApp;
import com.cvargas.dentalOffice.dentalOffice.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private AppUserRepository userRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("prueba");

        userRepository.save(new UserApp(
                "administrativo",
                "admin",
                "admin",
                password,
                AppUserRol.ROL_USER

        ));
    }
}
