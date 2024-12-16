package com.marymamani.aquariusservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private String name;
    private String token;
    private String refreshToken;
}
