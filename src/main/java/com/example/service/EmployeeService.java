package com.example.service;

import com.example.model.Absence;
import com.example.model.Employee;
import com.example.model.dto.AbsenceRequestDto;
import com.example.model.dto.AbsenceResponseDto;
import com.example.model.dto.EmployeeRequestDto;
import com.example.model.dto.EmployeeResponseDto;

public interface EmployeeService {

    EmployeeResponseDto getEmployee(Long id);

    EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto);


    EmployeeResponseDto toEmplyeeResponse(Employee employee);



}
