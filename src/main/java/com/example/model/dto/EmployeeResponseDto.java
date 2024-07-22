package com.example.model.dto;

import com.example.model.enums.EmployeeRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Data
public class EmployeeResponseDto {

    @NotNull
    private String givenName;

    @NotNull
    private String familyName;

    @NotNull
    private String email;
    @NotNull
    private EmployeeRole role;
}
