package com.example.model.dto;

import com.example.model.Employee;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AbsenceRequestDto {

    @NotNull
    Employee employee;

    @NotNull
    LocalDate fromDate;

    @NotNull
    LocalDate toDate;
}
