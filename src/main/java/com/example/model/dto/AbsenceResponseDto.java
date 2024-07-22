package com.example.model.dto;

import com.example.model.enums.AbsenceStatus;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceResponseDto {

    @NotNull
    String employeeName;
    @NotNull
    private LocalDate fromDate;
    @NotNull
    private LocalDate toDate;
    @NotNull
    private AbsenceStatus status;

}
