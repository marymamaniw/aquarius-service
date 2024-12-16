package com.marymamani.aquariusservice.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String message;

    private String details;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
