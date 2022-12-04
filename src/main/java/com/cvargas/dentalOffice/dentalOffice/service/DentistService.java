package com.cvargas.dentalOffice.dentalOffice.service;

import com.cvargas.dentalOffice.dentalOffice.dao.interfaces.IDaoCrud;
import com.cvargas.dentalOffice.dentalOffice.dto.DentistDto;
import com.cvargas.dentalOffice.dentalOffice.models.Dentist;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DentistService {

    private final IDaoCrud<Dentist> dentistDao;
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    public DentistService(IDaoCrud<Dentist> dentistDao) {
        this.dentistDao = dentistDao;
    }

    public DentistDto create(Dentist dentist) {

        dentistDao.create(dentist);
        return mapper.convertValue(dentist, DentistDto.class);
    }

    public List<DentistDto> readAll() {

        List<Dentist> dentistList = dentistDao.readAll();
        List<DentistDto> dentistDtoList = new ArrayList<>();
        dentistList.forEach(dentist -> dentistDtoList.add(mapper.convertValue(dentist, DentistDto.class)));

        return dentistDtoList;
    }

    public DentistDto read(int id) {

        Dentist dentist = dentistDao.read(id);

        return mapper.convertValue(dentist, DentistDto.class);
    }

    // void
    public void update(DentistDto dentistDto) {
        Dentist dentist = mapper.convertValue(dentistDto, Dentist.class);
        dentistDao.update(dentist);

    }

    public void delete(Integer id) {
        dentistDao.delete(id);
    }

}
