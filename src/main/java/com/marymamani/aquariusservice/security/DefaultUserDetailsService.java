package com.marymamani.aquariusservice.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    private final String defaultUsername = "marymamani.w@gmail.com";
    private final String defaultPassword = "$2a$10$OOG2s9/tEfQLnnGq0OwMZee.cE.dSnsKtKk6GfmLWnbfbUcWCqfau";
    private final String defaultRole = "ADMIN";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!username.equals(defaultUsername)) {
            throw new IllegalArgumentException("Correo electrónico no registrado");
        }

        return new DefaultUserDetails(defaultUsername, defaultPassword, defaultRole);
    }
}
