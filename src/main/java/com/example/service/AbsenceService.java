package com.example.service;

import com.example.model.Absence;
import com.example.model.dto.AbsenceRequestDto;
import com.example.model.dto.AbsenceResponseDto;

public interface AbsenceService {


    AbsenceResponseDto getAbsence(Long id);

    AbsenceResponseDto createAbsence(AbsenceRequestDto requestDto);

    void approveAbsence(Long id);

    void declineAbsence(Long id);

    AbsenceResponseDto toAbsenceResponse(Absence absence);

}
