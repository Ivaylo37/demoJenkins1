package com.example.service;

import com.example.model.Absence;
import com.example.model.dto.AbsenceRequestDto;
import com.example.model.dto.AbsenceResponseDto;
import com.example.model.enums.AbsenceStatus;
import com.example.repository.AbsenceRepository;
import org.springframework.stereotype.Service;

@Service
public class AbsenceServiceImpl implements AbsenceService{
    private final AbsenceRepository absenceRepository;

    public AbsenceServiceImpl(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    @Override
    public AbsenceResponseDto getAbsence(Long id) {
        return toAbsenceResponse(absenceRepository.findAbsenceById(id));
    }

    @Override
    public AbsenceResponseDto createAbsence(AbsenceRequestDto requestDto) {
        Absence newAbsence = new Absence();
        newAbsence.setEmployee(requestDto.getEmployee());
        newAbsence.setFromDate(requestDto.getFromDate());
        newAbsence.setToDate(requestDto.getToDate());
        newAbsence.setStatus(AbsenceStatus.PENDING);
        try {
            absenceRepository.save(newAbsence);
            return toAbsenceResponse(newAbsence);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void approveAbsence(Long id) {
        Absence absence = absenceRepository.findAbsenceById(id);
        absence.setStatus(AbsenceStatus.APPROVED);
    }

    @Override
    public void declineAbsence(Long id) {
        Absence absence = absenceRepository.findAbsenceById(id);
        absence.setStatus(AbsenceStatus.REJECTED);
    }

    @Override
    public AbsenceResponseDto toAbsenceResponse(Absence absence) {
        return new AbsenceResponseDto(absence.getEmployee().getGivenName(), absence.getFromDate(), absence.getToDate(), absence.getStatus());
    }
}
