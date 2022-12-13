package com.cvargas.dentalOffice.dentalOffice.model.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserApp implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String username;

    private String email;

    private String password;

    private AppUserRol appUserRol;

    public UserApp(String name, String username, String email, String password, AppUserRol appUserRol) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.appUserRol = appUserRol;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // hacer los permisos y las autorizaciones
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUserRol.name());
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
