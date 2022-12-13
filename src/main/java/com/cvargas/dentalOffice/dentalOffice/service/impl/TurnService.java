package com.cvargas.dentalOffice.dentalOffice.service.impl;

import com.cvargas.dentalOffice.dentalOffice.dto.TurnDto;
import com.cvargas.dentalOffice.dentalOffice.model.Patient;
import com.cvargas.dentalOffice.dentalOffice.model.Turn;
import com.cvargas.dentalOffice.dentalOffice.repository.TurnRepository;
import com.cvargas.dentalOffice.dentalOffice.service.ITurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnService implements ITurnService {


    ObjectMapper mapper;
    private final TurnRepository turnRepository;

    @Autowired
    private static final Logger logger = Logger.getLogger(TurnService.class);



    @Autowired
    public TurnService(ObjectMapper mapper, TurnRepository turnRepository) {
        this.mapper = mapper;
        this.turnRepository = turnRepository;
    }


    @Override
    public TurnDto create(Turn turn) {
        logger.info("Creating turn...");

        turnRepository.save(turn);
        return mapper.convertValue(turn, TurnDto.class);
    }

    @Override
    public Set<TurnDto> readAll() {
        List<Turn> turnList = turnRepository.findAll();
        Set<TurnDto> turnDtoList = new HashSet<>();
        logger.info("Searching all the turns...");
        // recorre los turnos de la lista y los convierte a turnDto
        turnList.forEach(turn -> turnDtoList.add(mapper.convertValue(turn, TurnDto.class)));
        return turnDtoList;
    }

    @Override
    public TurnDto read(Long id) {
        Optional<Turn> turn = turnRepository.findById(id);
        TurnDto turnDto = null;
        if(turn.isPresent()) {
            logger.info("Searching turn with id= " + id);

            turnDto = mapper.convertValue(turn.get(), TurnDto.class);
        }
        return turnDto;
    }


    @Override
    public Turn update(TurnDto turnDto) {
        logger.info("Updating turn data...");

        Turn turn = mapper.convertValue(turnDto, Turn.class);
        return turnRepository.save(turn);
    }

    @Override
    public void delete(Long id) {
        logger.info("Removing turn...");
        turnRepository.deleteById(id);
    }
}
