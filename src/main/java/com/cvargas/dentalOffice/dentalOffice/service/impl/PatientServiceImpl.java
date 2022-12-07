package com.cvargas.dentalOffice.dentalOffice.service.impl;

import com.cvargas.dentalOffice.dentalOffice.dao.PatientDaoH2;
import com.cvargas.dentalOffice.dentalOffice.dto.PatientDto;

import com.cvargas.dentalOffice.dentalOffice.model.Patient;
import com.cvargas.dentalOffice.dentalOffice.repository.PatientRepository;
import com.cvargas.dentalOffice.dentalOffice.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements IPatientService {
    PatientRepository patientRepository;
    @Autowired
    ObjectMapper mapper;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDto create(Patient patient) {
        patientRepository.save(patient);
        return mapper.convertValue(patient, PatientDto.class);
    }

    @Override
    public List<PatientDto> readAll() {

        List<Patient> patientsList = patientRepository.findAll();
        List<PatientDto> patientDtoList = new ArrayList<>();
        patientsList.forEach(patient -> patientDtoList.add(mapper.convertValue(patient, PatientDto.class)));

        return patientDtoList;
    }

    @Override
    public PatientDto read(Integer id) {
        Optional<Patient> patient = patientRepository.findById(Long.valueOf(id));
        return mapper.convertValue(patient, PatientDto.class);
    }


    @Override
    public void delete(Integer id) {
        patientRepository.deleteById(Long.valueOf(id));
    }

}
