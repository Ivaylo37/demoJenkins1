package com.example.demo;

import com.example.model.Employee;
import com.example.model.dto.EmployeeRequestDto;
import com.example.model.dto.EmployeeResponseDto;
import com.example.model.enums.EmployeeRole;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEmployee_ShouldReturnEmployeeResponseDto() {
        // Arrange
        Long employeeId = 1L;
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setGivenName("John");
        employee.setFamilyName("Doe");
        employee.setEmail("john.doe@example.com");
        employee.setRole(EmployeeRole.USER);

        when(employeeRepository.findByEmployeeId(employeeId)).thenReturn(employee);

        // Act
        EmployeeResponseDto result = employeeService.getEmployee(employeeId);

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getGivenName());
        assertEquals("Doe", result.getFamilyName());
        assertEquals("john.doe@example.com", result.getEmail());
        assertEquals(EmployeeRole.USER, result.getRole());

        verify(employeeRepository, times(1)).findByEmployeeId(employeeId);
    }

    @Test
    void createEmployee_ShouldCreateAndReturnEmployeeResponseDto() {
        // Arrange
        EmployeeRequestDto requestDto = new EmployeeRequestDto();
        requestDto.setGivenName("Jane");
        requestDto.setFamilyName("Smith");
        requestDto.setEmail("jane.smith@example.com");

        Employee savedEmployee = new Employee();
        savedEmployee.setId(1L);
        savedEmployee.setGivenName(requestDto.getGivenName());
        savedEmployee.setFamilyName(requestDto.getFamilyName());
        savedEmployee.setEmail(requestDto.getEmail());
        savedEmployee.setRole(EmployeeRole.USER);

        when(employeeRepository.save(any(Employee.class))).thenReturn(savedEmployee);

        // Act
        EmployeeResponseDto result = employeeService.createEmployee(requestDto);

        // Assert
        assertNotNull(result);
        assertEquals("Jane", result.getGivenName());
        assertEquals("Smith", result.getFamilyName());
        assertEquals("jane.smith@example.com", result.getEmail());
        assertEquals(EmployeeRole.USER, result.getRole());

        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void createEmployee_ShouldThrowException_WhenRepositoryThrowsException() {
        // Arrange
        EmployeeRequestDto requestDto = new EmployeeRequestDto();
        requestDto.setGivenName("Jane");
        requestDto.setFamilyName("Smith");
        requestDto.setEmail("jane.smith@example.com");

        when(employeeRepository.save(any(Employee.class))).thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> employeeService.createEmployee(requestDto));
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void toEmployeeResponse_ShouldConvertEmployeeToEmployeeResponseDto() {
        // Arrange
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setGivenName("John");
        employee.setFamilyName("Doe");
        employee.setEmail("john.doe@example.com");
        employee.setRole(EmployeeRole.USER);

        // Act
        EmployeeResponseDto result = employeeService.toEmplyeeResponse(employee);

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getGivenName());
        assertEquals("Doe", result.getFamilyName());
        assertEquals("john.doe@example.com", result.getEmail());
        assertEquals(EmployeeRole.USER, result.getRole());
    }
}