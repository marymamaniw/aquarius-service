package com.marymamani.aquariusservice.exception.custom;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ValidationErrorResponse extends ErrorResponse {

    private Map<String, List<String>> errors;

    public ValidationErrorResponse(String message, Map<String, List<String>> errors) {
        super(message);
        this.errors = errors;
    }
}
