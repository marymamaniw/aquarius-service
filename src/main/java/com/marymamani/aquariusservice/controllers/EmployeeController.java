package com.marymamani.aquariusservice.controllers;

import com.marymamani.aquariusservice.dtos.EmployeeDto;
import com.marymamani.aquariusservice.models.Employee;
import com.marymamani.aquariusservice.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        Employee employeeCreated = employeeService.createEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeCreated);
    }

    @PutMapping("{employeeCode}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable UUID employeeCode, @Valid @RequestBody EmployeeDto employeeDto) {
        Employee employeeUpdated = employeeService.updateEmployee(employeeCode , employeeDto);
        return ResponseEntity.ok(employeeUpdated);
    }

    @DeleteMapping("{employeeCode}")
    public ResponseEntity<UUID> deleteEmployee(@PathVariable UUID employeeCode) {
        UUID deletedEmployeeCode = employeeService.deleteEmployee(employeeCode);
        return ResponseEntity.ok(deletedEmployeeCode);
    }
}
