package com.cvargas.dentalOffice.dentalOffice.service.impl;

import com.cvargas.dentalOffice.dentalOffice.dto.DentistDto;
import com.cvargas.dentalOffice.dentalOffice.model.Dentist;
import com.cvargas.dentalOffice.dentalOffice.repository.DentistRepository;
import com.cvargas.dentalOffice.dentalOffice.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DentistServiceImpl implements IDentistService {

    private DentistRepository dentistRepository;
    private ObjectMapper mapper;

    private static final Logger logger = Logger.getLogger(DentistServiceImpl.class);

    @Autowired
    public DentistServiceImpl(DentistRepository dentistRepository, ObjectMapper mapper) {
        this.dentistRepository = dentistRepository;
        this.mapper = mapper;
    }

    public DentistDto create(Dentist dentist) {
        logger.info("Creating dentist...");
        dentistRepository.save(dentist);
        return mapper.convertValue(dentist, DentistDto.class);
    }

    @Override
    public DentistDto read(Long id) {
        logger.info("Searching dentist with id= " + id);
        Optional<Dentist> dentist = dentistRepository.findById(id);
        DentistDto dentistDto = null;
        if(dentist.isPresent()) {
            dentistDto = mapper.convertValue(dentist, DentistDto.class);
        }
        return dentistDto;
    }

    @Override
    public Set<DentistDto> readAll() {
        logger.info("Searching all the dentists...");
        List<Dentist> dentistList = dentistRepository.findAll();
        Set<DentistDto> dentistDtoList = new HashSet<>();

        dentistList.forEach(dentist -> dentistDtoList.add(mapper.convertValue(dentist, DentistDto.class)));
        return  dentistDtoList;
    }

    @Override
    public Dentist updateAll(Dentist dentist) {
        Dentist response = null;
        Optional<Dentist> dentistDB = dentistRepository.findById(dentist.getId());

        if(dentistDB.isPresent()) {
            logger.info("Updating all dentist data...");
            response = dentistRepository.save(dentist);
        }
        return response;
    }

    @Override
    public Dentist updateName_LastName(DentistDto dentistDto) {

        Dentist dentist = mapper.convertValue(dentistDto, Dentist.class);
        Optional<Dentist> dentistDB = dentistRepository.findById(dentist.getId());

        Dentist response = null;
        if(dentistDB.isPresent()) {
            logger.info("Updating the dentist's first and last name...");
            response = dentistRepository.save(dentistDB.get());
        }

        return response;
    }


    @Override
    public void delete(Long id) {
        logger.info("Removing dentist...");

        dentistRepository.deleteById(id);
    }
}
