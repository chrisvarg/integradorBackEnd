package com.cvargas.dentalOffice.dentalOffice.controller;

import com.cvargas.dentalOffice.dentalOffice.dto.DentistDto;
import com.cvargas.dentalOffice.dentalOffice.models.Dentist;
import com.cvargas.dentalOffice.dentalOffice.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping
    public List<DentistDto> dentistAll() {
        return dentistService.readAll();
    }


    // TODO: Hacer logica para que devuelva una respuesta si no encuentra datos
    @GetMapping("/{id}")
    public DentistDto dentistById(@PathVariable Integer id) {

        return dentistService.read(id);
    }

    // TODO: Hacer logica para que devuelva una respuesta si no encuentra datos
    @PostMapping
    public DentistDto createDentist(@RequestBody Dentist dentist) {
        return dentistService.create(dentist);
    }

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

    @DeleteMapping("/{id}")
    public String deleteDentist(@PathVariable Integer id) {
        String response = "Error el id ingresado no es correcto";
        if(dentistService.read(id) != null) {
            dentistService.delete(id);
            response = "Se elimino al odocntolo con id= " + id;
        }

        return response;
    }

}
