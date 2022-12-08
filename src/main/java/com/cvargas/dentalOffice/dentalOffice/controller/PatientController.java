package com.cvargas.dentalOffice.dentalOffice.controller;

import com.cvargas.dentalOffice.dentalOffice.dto.PatientDto;
import com.cvargas.dentalOffice.dentalOffice.model.Patient;
import com.cvargas.dentalOffice.dentalOffice.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    PatientServiceImpl patientServiceImpl;

    @Autowired
    public PatientController(PatientServiceImpl patientServiceImpl) {
        this.patientServiceImpl = patientServiceImpl;
    }

    @GetMapping
    public ResponseEntity<?> patientAll() {
        ResponseEntity<?> response =ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The information not found");
        List<PatientDto> patientDtoList = patientServiceImpl.readAll();
        if(patientDtoList.size() > 0) {
            response = ResponseEntity.ok(patientDtoList);
        }

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> patientById(@PathVariable Integer id) {
        ResponseEntity<?> response = null;
        PatientDto patientDto = patientServiceImpl.read(id);
        if(patientDto != null) {
            response = ResponseEntity.ok(patientDto);
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("The patient is not found");
        }

        return response;
    }

    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody Patient patient) {
        ResponseEntity<?> response = null;
        PatientDto patientDto = patientServiceImpl.create(patient);
        if( patientDto != null) {
            response = ResponseEntity.status(HttpStatus.OK).header("Message", "Patient data was saved successfully\n")
                    .body(patientDto);
        } else {
            response = ResponseEntity.badRequest().body("Oops!! Something went wrong");
        }

        return response;
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer id) {
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The Id entered was not found\n");
        if(patientServiceImpl.read(id) != null) {
            patientServiceImpl.delete(id);
            response = ResponseEntity.status(HttpStatus.OK).body("The dentist is deleted");
        }

        return response;
    }

}
