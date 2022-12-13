package com.cvargas.dentalOffice.dentalOffice.service.impl;

import com.cvargas.dentalOffice.dentalOffice.dto.DentistDto;
import com.cvargas.dentalOffice.dentalOffice.model.Dentist;
import com.cvargas.dentalOffice.dentalOffice.repository.DentistRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class DentistServiceImplTest {

    private static final Long ID_TEST = 1L;
    private static final String NAME_TEST = "manuel";
    private static final String LASTNAME_TEST = "sanchez";
    private static final String LICENSE_TEST = "1234";

    @Autowired
    DentistServiceImpl dentistService;

    ObjectMapper mapper = new ObjectMapper();

    Dentist dentist;
    DentistDto dentistDto;



    @BeforeEach
    @DisplayName("Test dentistServiceImpl")
    void setUp() {

        dentist = new Dentist(null, NAME_TEST, LASTNAME_TEST, LICENSE_TEST);
        dentistDto = mapper.convertValue(dentist, DentistDto.class);
    }

    @Test
    void create() {
//        dentistService.create(dentist);
//        Assertions.assertNotNull(dentistDto);
//        Assertions.assertEquals(1, dentistDto.getId());
    }

    @Test
    void read() {
    }

    @Test
    void delete() {
    }
}