package com.example.service;

import com.example.model.Employee;
import com.example.model.dto.EmployeeRequestDto;
import com.example.model.dto.EmployeeResponseDto;
import com.example.model.enums.EmployeeRole;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDto getEmployee(Long id) {
        Employee employee = employeeRepository.findByEmployeeId(id);
        return toEmplyeeResponse(employee);
    }

    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto) {
        Employee newEmployee = new Employee();
        newEmployee.setGivenName(requestDto.getGivenName());
        newEmployee.setFamilyName(requestDto.getFamilyName());
        newEmployee.setEmail(requestDto.getEmail());
        newEmployee.setRole(EmployeeRole.USER);
        try {
            employeeRepository.save(newEmployee);
            return toEmplyeeResponse(newEmployee);
        } catch (Exception e) {
            //log
            throw e;
        }
    }

    @Override
    public EmployeeResponseDto toEmplyeeResponse(Employee employee) {
        return new EmployeeResponseDto(employee.getId(), employee.getGivenName(),
                employee.getFamilyName(), employee.getEmail(), employee.getRole());
    }
}
