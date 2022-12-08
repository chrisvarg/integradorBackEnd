package com.cvargas.dentalOffice.dentalOffice.service;

import com.cvargas.dentalOffice.dentalOffice.dto.PatientDto;
import com.cvargas.dentalOffice.dentalOffice.dto.TurnDto;
import com.cvargas.dentalOffice.dentalOffice.model.Patient;
import com.cvargas.dentalOffice.dentalOffice.model.Turn;

import java.util.List;

public interface ITurnService {
    public TurnDto create(Turn turn);
    TurnDto read(Integer id);
    List<TurnDto> readAll();
    void delete(Integer id);
}
