package com.marymamani.aquariusservice.services;

import com.marymamani.aquariusservice.dtos.AreaDto;
import com.marymamani.aquariusservice.dtos.mappers.AreaMapper;
import com.marymamani.aquariusservice.exception.custom.ItemAlreadyExistsException;
import com.marymamani.aquariusservice.exception.custom.NotFoundException;
import com.marymamani.aquariusservice.models.Area;
import com.marymamani.aquariusservice.repositories.AreaRepository;
import com.marymamani.aquariusservice.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;
    private final AreaMapper areaMapper;
    private final EmployeeRepository employeeRepository;

    public List<Area> getAllAreas() {
        return areaRepository.findAll();
    }

    public Area createArea(AreaDto areaDto) {
        Area areaNameExists = areaRepository.findByName(areaDto.getName());
        if (areaNameExists != null) {
            String message = String.format("Area con nombre %s ya existe", areaNameExists.getName());
            throw new ItemAlreadyExistsException(message);
        } else {
            Area area = areaMapper.toArea(areaDto);
            areaRepository.save(area);
            return area;
        }
    }

    public Area updateArea(UUID areaCode, AreaDto areaDto) {
        Area existingArea = getAreaById(areaCode);
        Area updatedArea = areaMapper.toArea(areaDto);
        updatedArea.setCode(existingArea.getCode());
        return areaRepository.save(updatedArea);
    }

    public UUID deleteArea(UUID areaCode) {
        Area existingArea = getAreaById(areaCode);
        boolean areaWithEmployees = employeeRepository.existsByAreaCode(areaCode);
        if (areaWithEmployees) {
            throw new IllegalArgumentException("No se puede eliminar el área porque hay empleados asignados a este área");
        }
        areaRepository.delete(existingArea);
        return areaCode;
    }

    protected Area getAreaById(UUID areaCode) {
        return areaRepository.findById(areaCode)
                .orElseThrow(() -> new NotFoundException("No se encontró área con ese código"));
    }
}
