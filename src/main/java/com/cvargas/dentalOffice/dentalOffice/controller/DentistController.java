package com.cvargas.dentalOffice.dentalOffice.controller;

import com.cvargas.dentalOffice.dentalOffice.dto.DentistDto;
import com.cvargas.dentalOffice.dentalOffice.dto.PatientDto;
import com.cvargas.dentalOffice.dentalOffice.exceptions.ResourceNotFoundException;
import com.cvargas.dentalOffice.dentalOffice.model.Dentist;
import com.cvargas.dentalOffice.dentalOffice.model.Patient;
import com.cvargas.dentalOffice.dentalOffice.service.impl.DentistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private final DentistServiceImpl dentistServiceImpl;

    @Autowired
    public DentistController(DentistServiceImpl dentistServiceImpl) {
        this.dentistServiceImpl = dentistServiceImpl;
    }

    @GetMapping
    public ResponseEntity<?> dentistAll() {
        ResponseEntity<?> response =ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The information not found");
        Collection<DentistDto> dentistDtoList = dentistServiceImpl.readAll();
        if(dentistDtoList.size() > 0) {
            response = ResponseEntity.ok(dentistDtoList);
        }

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> dentistById(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<?> response = null;
        DentistDto dentistDto = dentistServiceImpl.read(id);
        if(dentistDto != null) {
            response = ResponseEntity.ok(dentistDto);
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("The dentist is not found");
        }

        return response;
    }

    @PostMapping
    public ResponseEntity<?> createDentist(@RequestBody Dentist dentist) {
        ResponseEntity<?> response = null;
        DentistDto dentistDto = dentistServiceImpl.create(dentist);
        if( dentistDto != null) {
            response = ResponseEntity.status(HttpStatus.OK).header("Message", "Dentist data was saved successfully\n")
                    .body(dentistDto);
        } else {
            response = ResponseEntity.badRequest().body("Oops!! Something went wrong");
        }

        return response;
    }

    // TODO -> Mirar como hacer esto con HQL


    @PutMapping
    public ResponseEntity<?> upadateDentist(@RequestBody Dentist dentist) throws ResourceNotFoundException {
        ResponseEntity<?> response = null;
        Dentist dentistDB = dentistServiceImpl.updateAll(dentist);
        if( dentistDB != null) {
            response = ResponseEntity.status(HttpStatus.OK).header("Message", "Dentist details have been successfully updated")
                    .body(dentistDB);
        } else {
            response = ResponseEntity.badRequest().body("Oops!! Something went wrong");
        }

        return response;
    }

    @PatchMapping
    public ResponseEntity<?> updateNameAndLastName(@RequestBody DentistDto dentistDto) throws ResourceNotFoundException {
        ResponseEntity<?> response = null;


        Dentist dentistDB = dentistServiceImpl.updateName_LastName(dentistDto);
        if( dentistDB != null) {
            response = ResponseEntity.status(HttpStatus.OK).header("Message", "Dentist details have been successfully updated")
                    .body(dentistDB);
        } else {
            response = ResponseEntity.badRequest().body("Oops!! Something went wrong");
        }

        return response;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentist(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<?> response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The Id entered was not found\n");
        if(dentistServiceImpl.read(id) != null) {
            dentistServiceImpl.delete(id);
            response = ResponseEntity.status(HttpStatus.OK).body("The dentist is deleted");
        }

        return response;
    }
}
