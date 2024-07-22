package com.example.model.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Data
public class EmployeeRequestDto {

    @NotNull
    private final String givenName;

    @NotNull
    private final String familyName;

    @NotNull
    private final String email;
}
