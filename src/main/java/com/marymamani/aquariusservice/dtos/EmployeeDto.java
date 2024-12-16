package com.marymamani.aquariusservice.dtos;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EmployeeDto {

    @NotBlank(message = "{validation.employee.name.notblank}")
    @Size(max = 100, message = "{validation.employee.name.size}")
    private String name;

    @NotNull(message = "{validation.employee.areaCode.notnull}")
    private UUID areaCode;

    @NotBlank(message = "{validation.employee.email.notblank}")
    @Size(max = 100, message = "{validation.employee.email.size}")
    @Email(message = "{validation.employee.email.format}")
    private String email;

    @NotBlank(message = "{validation.employee.phoneNumber.notblank}")
    @Size(max = 9, message = "{validation.employee.phoneNumber.size}")
    @Pattern(regexp = "\\d{9}", message = "{validation.employee.phoneNumber.digits}")
    private String phoneNumber;
}
