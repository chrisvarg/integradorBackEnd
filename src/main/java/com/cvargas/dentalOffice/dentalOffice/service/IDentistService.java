package com.cvargas.dentalOffice.dentalOffice.service;


import com.cvargas.dentalOffice.dentalOffice.dto.DentistDto;
import com.cvargas.dentalOffice.dentalOffice.model.Dentist;

import java.util.Set;

public interface IDentistService {
    DentistDto create(Dentist dentist);
    DentistDto read(Long id);
    Set<DentistDto> readAll();

    Dentist updateAll(Dentist dentist);
    Dentist updateName_LastName(DentistDto dentistDto);

    void delete(Long id);
}
