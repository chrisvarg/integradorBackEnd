package com.cvargas.dentalOffice.dentalOffice.service.impl;

import com.cvargas.dentalOffice.dentalOffice.dto.PatientDto;
import com.cvargas.dentalOffice.dentalOffice.model.Dentist;
import com.cvargas.dentalOffice.dentalOffice.model.Patient;
import com.cvargas.dentalOffice.dentalOffice.repository.PatientRepository;
import com.cvargas.dentalOffice.dentalOffice.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientServiceImpl implements IPatientService {
    private final PatientRepository patientRepository;
    private final ObjectMapper mapper;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, ObjectMapper mapper) {
        this.patientRepository = patientRepository;
        this.mapper = mapper;
    }


    @Override
    public PatientDto create(Patient patient) {
        patientRepository.save(patient);
        return mapper.convertValue(patient, PatientDto.class);
    }

    @Override
    public Set<PatientDto> readAll() {
        List<Patient> patientsList = patientRepository.findAll();
        patientsList.forEach(System.out::println);
        Set<PatientDto> patientDtoList = new HashSet<>();
        // recorre los patients de la lista y los convierte a patientDto
        patientsList.forEach(patient -> patientDtoList.add(mapper.convertValue(patient, PatientDto.class)));
        return patientDtoList;
    }

    @Override
    public PatientDto read(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDto patientDto = null;
        if(patient.isPresent()){
            patientDto = mapper.convertValue(patient, PatientDto.class);
        }
        return patientDto;
    }

    @Override
    public Patient update(Patient patient) {
        Patient response = null;
        Optional<Patient> patientDB = patientRepository.findById(patient.getId());

        if(patientDB.isPresent()) {
            response = patientRepository.save(patient);
        }
        return response;
    }

    @Override
    public Patient updateName_lastName_email(PatientDto patientDto) {
        Patient patient = mapper.convertValue(patientDto, Patient.class);
        Optional<Patient> patientDB = patientRepository.findById(patient.getId());

        Patient response = null;
        if(patientDB.isPresent()) {
            patient.setDNI(patientDB.get().getDNI());
            response = patientRepository.save(patient);
        }

        return response;
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

}
