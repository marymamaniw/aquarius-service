package com.marymamani.aquariusservice.services;

import com.marymamani.aquariusservice.dtos.EmployeeDto;
import com.marymamani.aquariusservice.dtos.mappers.EmployeeMapper;
import com.marymamani.aquariusservice.exception.custom.ItemAlreadyExistsException;
import com.marymamani.aquariusservice.exception.custom.NotFoundException;
import com.marymamani.aquariusservice.models.Area;
import com.marymamani.aquariusservice.models.Employee;
import com.marymamani.aquariusservice.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AreaService areaService;
    private final EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(EmployeeDto employeeDto) {
        if (employeeRepository.findByEmail(employeeDto.getEmail()).isPresent()) {
            throw new ItemAlreadyExistsException("Ya existe un empleado con ese email");
        }

        if (employeeRepository.findByPhoneNumber(employeeDto.getPhoneNumber()).isPresent()) {
            throw new ItemAlreadyExistsException("Ese número de celular ya está asignado a un empleado");
        }

        Area areaExisting = areaService.getAreaById(employeeDto.getAreaCode());

        Employee employee = employeeMapper.toEmployee(employeeDto, areaExisting);

        return employeeRepository.save(employee);
    }

    private Employee getEmployeeByCode(UUID employeeCode) {
        return employeeRepository.findById(employeeCode)
                .orElseThrow(() -> new NotFoundException("No se encontró ningún empleado con ese código"));
    }

    public UUID deleteEmployee(UUID employeeCode) {
        Employee existingEmployee = getEmployeeByCode(employeeCode);
        employeeRepository.delete(existingEmployee);
        return employeeCode;
    }

    public Employee updateEmployee(UUID employeeCode, EmployeeDto employeeDto) {
        Employee existingEmployee = getEmployeeByCode(employeeCode);

        Area areaExisting = areaService.getAreaById(employeeDto.getAreaCode());

        existingEmployee.setName(employeeDto.getName());
        existingEmployee.setArea(areaExisting);
        existingEmployee.setEmail(employeeDto.getEmail());
        existingEmployee.setPhoneNumber(employeeDto.getPhoneNumber());

        return employeeRepository.save(existingEmployee);
    }
}
