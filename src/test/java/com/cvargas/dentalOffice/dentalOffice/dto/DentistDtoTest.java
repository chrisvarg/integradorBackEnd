package com.cvargas.dentalOffice.dentalOffice.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DentistDtoTest {

    private static final Long ID_TEST = 1L;
    private static final String NAME_TEST = "manuel";
    private static final String LASTNAME_TEST = "sanchez";
    private DentistDto dentistDto;

    @BeforeEach
    @DisplayName("Test dentisDto")
    void setUp() {
        dentistDto = new DentistDto();
    }

    @Test
    void testGet_SetIdOdontologo() {
        dentistDto.setId(ID_TEST);
        Assertions.assertNotNull(dentistDto.getId());
        Assertions.assertEquals(1, dentistDto.getId());

    }

    @Test
    void testGet_SetName() {
        dentistDto.setName(NAME_TEST);
        Assertions.assertNotNull(dentistDto.getName());
        Assertions.assertEquals("manuel", dentistDto.getName());

    }

    @Test
    void testGet_SetLastName() {
        dentistDto.setLastName(LASTNAME_TEST);
        Assertions.assertNotNull(dentistDto.getLastName());
        Assertions.assertEquals("sanchez", dentistDto.getLastName());

    }

    @Test
    void testToString() {
        dentistDto = new DentistDto(
                ID_TEST, NAME_TEST, LASTNAME_TEST
        );
        Assertions.assertNotNull(dentistDto.toString());
        Assertions.assertEquals("DentistDto{id=1, name='manuel', lastName='sanchez'}", dentistDto.toString());
    }

}
