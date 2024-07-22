package com.example.model.dto;

import com.example.model.enums.EmployeeRole;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public class EmployeeResponseDto {
    @NotNull
    private Long id;

    @NotNull
    private String givenName;

    @NotNull
    private String familyName;

    @NotNull
    private String email;
    @NotNull
    private EmployeeRole role;
}
