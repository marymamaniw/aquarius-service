package com.marymamani.aquariusservice.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AreaDto {

    @NotBlank(message = "{validation.area.name.notblank}")
    @Size(max = 100, message = "{validation.area.name.size}")
    private String name;
}
