package com.example.demo.integration;

import com.example.exception.NotAuthorizedException;
import com.example.model.dto.EmployeeResponseDto;
import com.example.model.enums.AbsenceStatus;
import com.example.model.enums.EmployeeRole;
import com.example.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestExecutionListeners(listeners = WithSecurityContextTestExecutionListener.class)
public class ScheduleRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        // Set up mock EmployeeService behavior
        when(employeeService.getEmployee(anyLong())).thenReturn(new EmployeeResponseDto("John", "John", "Doe", EmployeeRole.USER));
    }

    @Test
    @WithMockUser
    void testGetCustomer() throws Exception {
        MvcResult result = mockMvc.perform(get("/employees/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json("{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\"}"))
                .andReturn();
    }

    @Test
    @WithMockUser
    void testGetCustomer_NotAuthorized() throws Exception {
        // Simulate NotAuthorizedException
        when(employeeService.getEmployee(anyLong())).thenThrow(new NotAuthorizedException("Not authorized"));

        mockMvc.perform(get("/employees/1"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    void testGetCustomer_NotFound() throws Exception {
        // Simulate Employee not found
        when(employeeService.getEmployee(anyLong())).thenReturn(null);

        mockMvc.perform(get("/employees/999"))
                .andExpect(status().isNotFound());
    }
}
