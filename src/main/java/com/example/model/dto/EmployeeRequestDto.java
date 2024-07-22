package com.example.model.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeRequestDto {

    @NotNull
    private String givenName;

    @NotNull
    private String familyName;

    @NotNull
    private String email;
}
