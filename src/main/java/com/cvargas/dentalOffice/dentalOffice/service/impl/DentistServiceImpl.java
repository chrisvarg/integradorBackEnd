package com.cvargas.dentalOffice.dentalOffice.service.impl;

import com.cvargas.dentalOffice.dentalOffice.dto.DentistDto;
import com.cvargas.dentalOffice.dentalOffice.model.Dentist;
import com.cvargas.dentalOffice.dentalOffice.repository.DentistRepository;
import com.cvargas.dentalOffice.dentalOffice.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements IDentistService {

    private DentistRepository dentistRepository;
    private ObjectMapper mapper;

    @Autowired
    public DentistServiceImpl(DentistRepository dentistRepository, ObjectMapper mapper) {
        this.dentistRepository = dentistRepository;
        this.mapper = mapper;
    }

    public DentistDto create(Dentist dentist) {

        dentistRepository.save(dentist);
        return mapper.convertValue(dentist, DentistDto.class);
    }

    @Override
    public DentistDto read(Integer id) {
        Optional<Dentist> dentist = dentistRepository.findById(Long.valueOf(id));
        return mapper.convertValue(dentist, DentistDto.class);
    }

    @Override
    public List<DentistDto> readAll() {
        List<Dentist> dentistList = dentistRepository.findAll();
        List<DentistDto> dentistDtoList = new ArrayList<>();

        dentistList.forEach(dentist -> dentistDtoList.add(mapper.convertValue(dentist, DentistDto.class)));
        return  dentistDtoList;
    }

    @Override
    public void delete(Integer id) {
        dentistRepository.deleteById(Long.valueOf(id));
    }
}
