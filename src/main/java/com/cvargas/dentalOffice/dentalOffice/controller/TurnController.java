package com.cvargas.dentalOffice.dentalOffice.controller;

import com.cvargas.dentalOffice.dentalOffice.dto.TurnDto;
import com.cvargas.dentalOffice.dentalOffice.exceptions.ResourceNotFoundException;
import com.cvargas.dentalOffice.dentalOffice.model.Turn;
import com.cvargas.dentalOffice.dentalOffice.service.impl.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turn")
public class TurnController {

    private final TurnService turnService;


    @Autowired
    public TurnController(TurnService turnService) {
        this.turnService = turnService;
    }

    @PostMapping
    public ResponseEntity<?> createTurn(@RequestBody Turn turn) {
        ResponseEntity<?> response = ResponseEntity.badRequest().body("Oops!! Something went wrong");
        TurnDto turnDto = turnService.create(turn);
        if(turnDto != null) {
            response = ResponseEntity.status(HttpStatus.OK)
                    .header("Turn data was saved successfully")
                    .body(turnDto);
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<?> turnAll() {
        ResponseEntity<?> response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Th information not found");
        Collection<TurnDto> turnDtoCollection = turnService.readAll();
        if(turnDtoCollection.size() > 0) {
            response = ResponseEntity.ok(turnDtoCollection);
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> turnById(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<?> response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The turn is not found");
        TurnDto turnDto = turnService.read(id);
        if(turnDto != null) {
            response = ResponseEntity.ok(turnDto);
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<?> updateTurn(@RequestBody TurnDto turnDto) throws ResourceNotFoundException {
        ResponseEntity<?> response = null;
        Turn turnDB = turnService.update(turnDto);
        if(turnDB != null) {
            response = ResponseEntity.status(HttpStatus.OK).header("Message", "Turn details have been successfully updated")
                    .body(turnDB);
        } else {
            response = ResponseEntity.badRequest().body("Oops!! Something went wrong");
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<?> response = null;

        if(turnService.read(id) != null) {
            turnService.delete(id);
            response = ResponseEntity.status(HttpStatus.OK)
                    .body("The turn is deleted");
        }

         return response;
    }

}
