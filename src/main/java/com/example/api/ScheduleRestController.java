package com.example.api;

import com.example.exception.NotAuthorizedException;
import com.example.model.dto.EmployeeResponseDto;
import com.example.service.AbsenceService;
import com.example.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class ScheduleRestController {

    private final EmployeeService employeeService;
    private final AbsenceService absenceService;

    @Autowired
    public ScheduleRestController(EmployeeService employeeService, AbsenceService absenceService) {
        this.employeeService = employeeService;
        this.absenceService = absenceService;
    }

    @Operation(
            summary = "Get a customer based on their cross system unique identifier",
            description = "Returns the customer object containing all the customer's data.",
            security = @SecurityRequirement(name = "swagger_oauth")
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer record found successfully.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeResponseDto.class))}),
            @ApiResponse(responseCode = "403", description = "The currently authenticated principal is not permitted to access this customer's data",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Employee with this id was not fond",
                    content = @Content)})
    @GetMapping("/{id}")
    public EmployeeResponseDto getCustomer(@AuthenticationPrincipal Jwt jwt, @PathVariable("id") Long employeeId) {
        extractUserId(jwt);
        return employeeService.getEmployee(employeeId);
    }

    private String extractUserId(Jwt jwt) {
        if (jwt != null && jwt.getSubject() != null) {
            return jwt.getSubject();
        } else {
            throw new NotAuthorizedException("No subject assigned.");
        }
    }

}
