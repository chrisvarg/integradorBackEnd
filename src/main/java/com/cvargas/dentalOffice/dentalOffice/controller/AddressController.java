package com.cvargas.dentalOffice.dentalOffice.controller;

import com.cvargas.dentalOffice.dentalOffice.dto.DentistDto;
import com.cvargas.dentalOffice.dentalOffice.model.Address;
import com.cvargas.dentalOffice.dentalOffice.dto.AddressDto;
import com.cvargas.dentalOffice.dentalOffice.service.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    // TODO -> controlador de prueba
    private AddressServiceImpl addressService;

    @Autowired
    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public AddressDto createAddress(@RequestBody Address address) {
        System.out.println("controller");
        System.out.println(address);
        return addressService.create(address);
    }

    @GetMapping
    public ResponseEntity<?> addressAll() {
        ResponseEntity response =ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The information not found");
        if(addressService.readAll().size() > 0) {
            response = ResponseEntity.ok(addressService.readAll());
        }

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> addressById(@PathVariable Integer id) {
        ResponseEntity response = null;
        AddressDto addressDto = addressService.read(id);
        if (addressDto != null) {
            response = ResponseEntity.ok(addressDto);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("The dentist is not found");
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Integer id) {
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The Id entered was not found\n");
        if(addressService.read(id) != null) {
            addressService.delete(id);
            response = ResponseEntity.status(HttpStatus.OK).body("The dentist is deleted");
        }

        return response;
    }
}
