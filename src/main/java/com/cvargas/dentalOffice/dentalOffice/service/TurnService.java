package com.cvargas.dentalOffice.dentalOffice.service;

import com.cvargas.dentalOffice.dentalOffice.dao.TurnDaoH2;
import com.cvargas.dentalOffice.dentalOffice.dto.TurnDto;
import com.cvargas.dentalOffice.dentalOffice.domain.Turn;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurnService {

    TurnDaoH2 turnDaoH2;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    public TurnService(TurnDaoH2 turnDaoH2) {
        this.turnDaoH2 = turnDaoH2;
    }

    // TODO: Hacer logica para que devuelva una respuesta si no encuentra datos
    public TurnDto create(Turn turn) {

        turnDaoH2.create(turn);
        return mapper.convertValue(turn, TurnDto.class);
    }

    // TODO: Hacer logica para que devuelva una respuesta si no encuentra datos
    public List<TurnDto> turnsAll() {
        List<Turn> turnList = turnDaoH2.readAll();
        List<TurnDto> turnDtoList = new ArrayList<>();

        turnList.forEach(turn -> turnDtoList.add(mapper.convertValue(turn, TurnDto.class)));

        return turnDtoList;
    }

    // TODO: Hacer logica para que devuelva una respuesta si no encuentra datos
    public TurnDto read(Integer id) {

        Turn turn = turnDaoH2.read(id);
        return mapper.convertValue(turn, TurnDto.class);
    }

    public void update(TurnDto turnDto) {
        Turn turn = mapper.convertValue(turnDto, Turn.class);
        turnDaoH2.update(turn);
    }

    public void delete(Integer id) {
        turnDaoH2.delete(id);
    }
}
