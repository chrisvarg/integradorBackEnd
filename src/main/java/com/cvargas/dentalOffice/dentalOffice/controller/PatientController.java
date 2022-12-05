package com.cvargas.dentalOffice.dentalOffice.controller;

import com.cvargas.dentalOffice.dentalOffice.dto.DentistDto;
import com.cvargas.dentalOffice.dentalOffice.dto.PatientDto;
import com.cvargas.dentalOffice.dentalOffice.models.Patient;
import com.cvargas.dentalOffice.dentalOffice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientDto> patientAll() {
        return patientService.patientsAll();
    }

    @GetMapping("/{id}")
    public PatientDto patientById(@PathVariable Integer id) {
        return patientService.read(id);
    }

    @PostMapping
    public PatientDto createPatient(@RequestBody Patient patient) {
        return patientService.create(patient);
    }

    @PutMapping
    public String update(@RequestBody Patient patient) {

        String response = "Error al actualizar, el id ingresado no es correcto";

        if(patientService.read(patient.getId()) != null) {

            patientService.update(patient);
            response = "Se actualizo todos los datos del Paciente con id= " + patient.getId();
        }

        return response;
    }


    @PatchMapping
    public String updateAllDataPatient(@RequestBody PatientDto patientDto) {
        String response = "Error al actualizar, el id ingresado no es correcto";

        if(patientService.read(patientDto.getId()) != null) {

            patientService.updateParcial(patientDto);
            response = "Se actualizo el Paciente con id= " + patientDto.getId();
        }

        return response;
    }

    @DeleteMapping("/id")
    public String deletePatient(@PathVariable Integer id) {
        String response = "Error el id ingresado no es correcto";
        if(patientService.read(id) != null) {
            patientService.delete(id);
            response = "Se elimino el paciente con id= " + id;
        }

        return response;
    }

}
