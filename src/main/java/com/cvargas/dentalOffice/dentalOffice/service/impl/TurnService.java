package com.cvargas.dentalOffice.dentalOffice.service.impl;

import com.cvargas.dentalOffice.dentalOffice.dto.TurnDto;
import com.cvargas.dentalOffice.dentalOffice.model.Turn;
import com.cvargas.dentalOffice.dentalOffice.repository.DentistRepository;
import com.cvargas.dentalOffice.dentalOffice.repository.PatientRepository;
import com.cvargas.dentalOffice.dentalOffice.repository.TurnRepository;
import com.cvargas.dentalOffice.dentalOffice.service.ITurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnService implements ITurnService {


    @Autowired
    ObjectMapper mapper;
    private TurnRepository turnRepository;
    private DentistRepository dentistRepository;
    private PatientRepository patientRepository;

    @Autowired
    public TurnService(TurnRepository turnRepository, DentistRepository dentistRepository, PatientRepository patientRepository) {
        this.turnRepository = turnRepository;
        this.dentistRepository = dentistRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    // TODO: Hacer logica para que devuelva una respuesta si no encuentra datos
    public TurnDto create(Turn turn) {

        System.out.println("service\n" + turn.getPatient());
        System.out.println("service\n" + turn.getDentist());
        System.out.println(turn);
        turnRepository.save(turn);
        return mapper.convertValue(turn, TurnDto.class);
    }

    @Override
    // TODO: Hacer logica para que devuelva una respuesta si no encuentra datos
    public List<TurnDto> readAll() {
        List<Turn> turnList = turnRepository.findAll();
        List<TurnDto> turnDtoList = new ArrayList<>();

        turnList.forEach(turn -> turnDtoList.add(mapper.convertValue(turn, TurnDto.class)));

        return turnDtoList;
    }

    @Override
    // TODO: Hacer logica para que devuelva una respuesta si no encuentra datos
    public TurnDto read(Integer id) {

        Optional<Turn> turn = turnRepository.findById(Long.valueOf(id));
        return mapper.convertValue(turn, TurnDto.class);
    }

    @Override
    public void delete(Integer id) {
        turnRepository.deleteById(Long.valueOf(id));
    }
}
