package com.cvargas.dentalOffice.dentalOffice.service;

import com.cvargas.dentalOffice.dentalOffice.dto.TurnDto;
import com.cvargas.dentalOffice.dentalOffice.model.Turn;

import java.util.Set;

public interface ITurnService {
    TurnDto create(Turn turn);
    TurnDto read(Long id);
    Set<TurnDto> readAll();

    Turn update(TurnDto turnDto);

    void delete(Long id);
}
