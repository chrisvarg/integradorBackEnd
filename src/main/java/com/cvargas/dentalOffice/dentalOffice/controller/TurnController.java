package com.cvargas.dentalOffice.dentalOffice.controller;

import com.cvargas.dentalOffice.dentalOffice.dto.DentistDto;
import com.cvargas.dentalOffice.dentalOffice.dto.PatientDto;
import com.cvargas.dentalOffice.dentalOffice.dto.TurnDto;
import com.cvargas.dentalOffice.dentalOffice.domain.Turn;
import com.cvargas.dentalOffice.dentalOffice.service.impl.DentistServiceImpl;
import com.cvargas.dentalOffice.dentalOffice.service.impl.PatientServiceImpl;
import com.cvargas.dentalOffice.dentalOffice.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turn")
public class TurnController {

    TurnService turnService;
    PatientServiceImpl patientServiceImpl;
    DentistServiceImpl dentistServiceImpl;

    @Autowired
    public TurnController(TurnService turnService, PatientServiceImpl patientServiceImpl, DentistServiceImpl dentistServiceImpl) {
        this.turnService = turnService;
        this.patientServiceImpl = patientServiceImpl;
        this.dentistServiceImpl = dentistServiceImpl;
    }



    @PostMapping
    public TurnDto createTurn(@RequestBody Turn turn) {
        PatientDto patientDto = patientServiceImpl.read(Integer.valueOf(turn.getPatient().getId().toString()));
        DentistDto dentistDto = dentistServiceImpl.read(Integer.valueOf(turn.getPatient().getId().toString()));
        TurnDto turnDto = null;
        
        if(patientDto != null && dentistDto != null) {
            turnDto = turnService.create(turn);
        }
        
        return turnDto;
    }

    @GetMapping
    public List<TurnDto> turnAll() {
        return turnService.turnsAll();
    }

    @GetMapping("/{id}")
    public TurnDto turnById(@PathVariable Integer id) {
        return turnService.read(id);
    }

    @PutMapping
    public String updateTurn(@RequestBody TurnDto turnDto) {
        String response = "Error al actualizar, el id ingresado no es correcto";

        if(patientServiceImpl.read(turnDto.getId()) != null) {

            turnService.update(turnDto);
            response = "Se actualizo todos los datos del Paciente con id= " + turnDto.getId();
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        String response = "Error el id ingresado no es correcto";
        if(turnService.read(id) != null) {
            turnService.delete(id);
            response = "Se elimino el paciente con id= " + id;
        }

        return response;
    }

}
