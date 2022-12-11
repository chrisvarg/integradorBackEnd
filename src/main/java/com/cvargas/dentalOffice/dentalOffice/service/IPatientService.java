package com.cvargas.dentalOffice.dentalOffice.service;

import com.cvargas.dentalOffice.dentalOffice.dto.AddressDto;
import com.cvargas.dentalOffice.dentalOffice.dto.PatientDto;
import com.cvargas.dentalOffice.dentalOffice.model.Address;
import com.cvargas.dentalOffice.dentalOffice.model.Patient;

import java.util.List;
import java.util.Set;

public interface IPatientService {
    PatientDto create(Patient patient);
    PatientDto read(Long id);

    Set<PatientDto> readAll();
    Patient update(Patient patient);

    Patient updateName_lastName_email(PatientDto patientDto);
    void delete(Long id);
}
