package com.marymamani.aquariusservice.dtos.mappers;

import com.marymamani.aquariusservice.dtos.EmployeeDto;
import com.marymamani.aquariusservice.models.Area;
import com.marymamani.aquariusservice.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEmployee(EmployeeDto employeeDto, Area area) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setArea(area);
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());

        return employee;
    }
}
