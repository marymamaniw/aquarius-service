package com.marymamani.aquariusservice.services;

import com.marymamani.aquariusservice.security.JwtTokenProvider;
import com.marymamani.aquariusservice.dtos.LoginRequestDto;
import com.marymamani.aquariusservice.dtos.LoginResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public LoginResponseDto signIn(LoginRequestDto loginRequest) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

        if (!passwordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {
            throw new IllegalArgumentException("Credenciales inválidas");
        }

        String token = jwtTokenProvider.generateToken(userDetails);
        String refreshToken = jwtTokenProvider.generateRefreshToken(new HashMap<>(), userDetails);

        LoginResponseDto response = new LoginResponseDto();
        response.setName("Mary Mamani");
        response.setToken(token);
        response.setRefreshToken(refreshToken);

        return response;
    }
}
