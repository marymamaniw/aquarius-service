package com.marymamani.aquariusservice.controllers;

import com.marymamani.aquariusservice.dtos.LoginRequestDto;
import com.marymamani.aquariusservice.dtos.LoginResponseDto;
import com.marymamani.aquariusservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponseDto logIn(@RequestBody LoginRequestDto loginRequest) {
        return authService.signIn(loginRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logOut() {
        return ResponseEntity.ok("Sessión cerrada exitosamente");
    }
}
