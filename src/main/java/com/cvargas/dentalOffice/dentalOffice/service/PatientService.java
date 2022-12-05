package com.cvargas.dentalOffice.dentalOffice.service;

import com.cvargas.dentalOffice.dentalOffice.dao.PatientDaoH2;
import com.cvargas.dentalOffice.dentalOffice.dto.PatientDto;
import com.cvargas.dentalOffice.dentalOffice.models.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    PatientDaoH2 patientDaoH2;
    @Autowired
    ObjectMapper mapper;

    @Autowired
    public PatientService(PatientDaoH2 patientDaoH2) {
        this.patientDaoH2 = patientDaoH2;
    }

    public PatientDto create(Patient patient) {
        patientDaoH2.create(patient);
        return mapper.convertValue(patient, PatientDto.class);
    }

    public List<PatientDto> patientsAll() {

        List<Patient> patientsList = patientDaoH2.readAll();
        List<PatientDto> patientDtoList = new ArrayList<>();
        patientsList.forEach(patient -> patientDtoList.add(mapper.convertValue(patient, PatientDto.class)));

        return patientDtoList;
    }

    public PatientDto read(Integer id) {
        Patient patient = patientDaoH2.read(id);
        return mapper.convertValue(patient, PatientDto.class);
    }
    public void updateParcial(PatientDto patientDto) {
        Patient request = mapper.convertValue(patientDto, Patient.class);
        Patient patient = patientDaoH2.read(patientDto.getId());
        request.setDNI(patient.getDNI());
        System.out.println(request+ " request parcial");
        System.out.println(patient+ " paciente");

        patientDaoH2.update(request);
    }

    public void update(Patient patient) {
        patientDaoH2.update(patient);
    }
    public void delete(Integer id) {
        patientDaoH2.delete(id);
    }

}
