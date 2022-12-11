package com.cvargas.dentalOffice.dentalOffice.controller;

import com.cvargas.dentalOffice.dentalOffice.dto.DentistDto;
import com.cvargas.dentalOffice.dentalOffice.dto.PatientDto;
import com.cvargas.dentalOffice.dentalOffice.exceptions.ResourceNotFoundException;
import com.cvargas.dentalOffice.dentalOffice.model.Dentist;
import com.cvargas.dentalOffice.dentalOffice.model.Patient;
import com.cvargas.dentalOffice.dentalOffice.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientServiceImpl patientServiceImpl;

    @Autowired
    public PatientController(PatientServiceImpl patientServiceImpl) {
        this.patientServiceImpl = patientServiceImpl;
    }

    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody Patient patient) {
        ResponseEntity<?> response = null;
        PatientDto patientDto = patientServiceImpl.create(patient);
        if( patientDto != null) {
            response = ResponseEntity.status(HttpStatus.OK)
                    .header("Message", "Patient data was saved successfully")
                    .body(patientDto);
        } else {
            response = ResponseEntity.badRequest().body("Oops!! Something went wrong");
        }

        return response;
    }

    @GetMapping
    public ResponseEntity<?> patientAll() {
        ResponseEntity<?> response =ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The information not found");
        Collection<PatientDto> patientDtoList = patientServiceImpl.readAll();
        if(patientDtoList.size() > 0) {
            response = ResponseEntity.ok(patientDtoList);
        }

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> patientById(@PathVariable Long id) {
        ResponseEntity<?> response = null;
        PatientDto patientDto = patientServiceImpl.read(id);
        if(patientDto != null) {
            response = ResponseEntity.ok(patientDto);
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("The patient is not found");
        }

        return response;
    }


    @PutMapping
    public ResponseEntity<?> upadtePatient(@RequestBody Patient patient) {
        ResponseEntity<?> response = null;
        Patient patientDB = patientServiceImpl.update(patient);
        if(patientDB != null) {
            response = ResponseEntity.status(HttpStatus.OK).header("Message", "Dentist details have been successfully updated")
                    .body(patientDB);
        } else {
            response = ResponseEntity.badRequest().body("Oops!! Something went wrong");
        }

        return response;
    }

    @PatchMapping
    public ResponseEntity<?> updateNameAndLastName(@RequestBody PatientDto patientDto) {
        ResponseEntity<?> response = null;

        Patient patientDB = patientServiceImpl.updateName_lastName_email(patientDto);
        if( patientDB != null) {
            response = ResponseEntity.status(HttpStatus.OK).header("Message", "Dentist details have been successfully updated")
                    .body(patientDB);
        } else {
            response = ResponseEntity.badRequest().body("Oops!! Something went wrong");
        }

        return response;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The Id entered was not found");
        if(patientServiceImpl.read(id) != null) {
            patientServiceImpl.delete(id);
            response = ResponseEntity.status(HttpStatus.OK).body("The dentist is deleted");
        }

        return response;
    }

}
