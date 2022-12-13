package com.cvargas.dentalOffice.dentalOffice.service;

import com.cvargas.dentalOffice.dentalOffice.model.login.UserApp;
import com.cvargas.dentalOffice.dentalOffice.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAppService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public UserAppService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserApp> user = appUserRepository.findByEmail(username);
        if(user.isPresent()) {
            return user.get();

        } else {
            throw new UsernameNotFoundException("The email not found");
        }
    }
}
