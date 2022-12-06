package com.cvargas.dentalOffice.dentalOffice.service;


import com.cvargas.dentalOffice.dentalOffice.dto.DentistDto;
import com.cvargas.dentalOffice.dentalOffice.model.Dentist;

import java.util.List;

public interface IDentistService {
    public DentistDto create(Dentist dentist);
    DentistDto read(Integer id);
    List<DentistDto> readAll();

    void delete(Integer id);
}
