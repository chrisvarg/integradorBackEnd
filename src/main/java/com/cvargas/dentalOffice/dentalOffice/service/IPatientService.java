package com.cvargas.dentalOffice.dentalOffice.service;

import com.cvargas.dentalOffice.dentalOffice.dto.AddressDto;
import com.cvargas.dentalOffice.dentalOffice.dto.PatientDto;
import com.cvargas.dentalOffice.dentalOffice.model.Address;
import com.cvargas.dentalOffice.dentalOffice.model.Patient;

import java.util.List;

public interface IPatientService {
    public PatientDto create(Patient patient);
    PatientDto read(Integer id);
    List<PatientDto> readAll();
    void delete(Integer id);
}
