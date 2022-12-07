package com.cvargas.dentalOffice.dentalOffice.controller;

import com.cvargas.dentalOffice.dentalOffice.dto.DentistDto;
import com.cvargas.dentalOffice.dentalOffice.dto.PatientDto;
import com.cvargas.dentalOffice.dentalOffice.model.Dentist;
import com.cvargas.dentalOffice.dentalOffice.service.impl.DentistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    DentistServiceImpl dentistServiceImpl;

    @Autowired
    public DentistController(DentistServiceImpl dentistServiceImpl) {
        this.dentistServiceImpl = dentistServiceImpl;
    }

    @GetMapping
    public ResponseEntity<?> dentistAll() {
        ResponseEntity<?> response =ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The information not found");
        List<DentistDto> dentistDtoList = dentistServiceImpl.readAll();
        if(dentistDtoList.size() > 0) {
            response = ResponseEntity.ok(dentistDtoList);
        }

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> dentistById(@PathVariable Integer id) {
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
        ResponseEntity response = null;
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

  /*
  // TODO: Hacer logica para que devuelva una respuesta si no encuentra datos
    @PatchMapping
    public String updateDentistParcial(@RequestBody DentistDto dentistDto) {

        String response = "Error al actualizar el id ingresado no es correcto";

        if(dentistService.read(dentistDto.getId()) != null) {
            dentistService.updateParcial(dentistDto);

            response = "Se actualizo al odontólogo con id= " + dentistDto.getId();
        }

        return response;
    }

    // TODO: cuando se usa jdbc vanila y queremos actualizar todo nos toca usar el modelo directo sin DTO
    @PutMapping
    public String updateAllDataDentist(@RequestBody Dentist dentist) {
        String response = "Error al actualizar el id ingresado no es correcto";

        if(dentistService.read(dentist.getId()) != null) {
            dentistService.update(dentist);

            response = "Se actualizo al odontólogo con id= " + dentist.getId();
        }

        return response;
    }

*/
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDentist(@PathVariable Integer id) {
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The Id entered was not found\n");
        if(dentistServiceImpl.read(id) != null) {
            dentistServiceImpl.delete(id);
            response = ResponseEntity.status(HttpStatus.OK).body("The dentist is deleted");
        }

        return response;
    }
}
