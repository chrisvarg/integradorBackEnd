package com.cvargas.dentalOffice.dentalOffice.dto;

import com.cvargas.dentalOffice.dentalOffice.model.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PatientDtoTest {

    private static final Long ID_TEST = 1L;
    private static final String NAME_TEST = "manuel";
    private static final String LASTNAME_TEST = "sanchez";
    private static final String EMAIL_TEST = "sanchez@test.com";
    private static final LocalDate DISCHARGEDAY_TEST = LocalDate.parse("2021-05-06");
    private static Address address;
    private static PatientDto patientDto;


    @BeforeEach
    @DisplayName("Test patientDto")
    void setUp() {
        patientDto = new PatientDto();
        address = (null);
    }

    @Test
    void testToString() {
        patientDto = new PatientDto(
                ID_TEST, NAME_TEST, LASTNAME_TEST, EMAIL_TEST, DISCHARGEDAY_TEST, address
        );
        Assertions.assertNotNull(patientDto.toString());
        Assertions.assertEquals("PatientDto{id=1, name='manuel', lastName='sanchez', email='sanchez@test.com', dischargeDay=2021-05-06, " +
                "address=null}", patientDto.toString());
        System.out.println(address);

    }

    @Test
    void testGet_SetId() {
        patientDto.setId(ID_TEST);
        Assertions.assertNotNull(patientDto.getId());
        Assertions.assertEquals(1, patientDto.getId());

    }

    @Test
    void testGet_setName() {
        patientDto.setName(NAME_TEST);
        Assertions.assertNotNull(patientDto.getName());
        Assertions.assertEquals("manuel", patientDto.getName());

    }

    @Test
    void testGet_setLastname() {
        patientDto.setLastname(LASTNAME_TEST);
        Assertions.assertNotNull(patientDto.getLastname());
        Assertions.assertEquals("sanchez", patientDto.getLastname());

    }

    @Test
    void testGet_setEmail() {
        patientDto.setEmail(EMAIL_TEST);
        Assertions.assertNotNull(patientDto.getEmail());
        Assertions.assertEquals("sanchez@test.com", patientDto.getEmail());

    }

    @Test
    void testGet_setDischargeDay() {
        patientDto.setDischargeDay(DISCHARGEDAY_TEST);
        Assertions.assertNotNull(patientDto.getDischargeDay());
        Assertions.assertEquals("2021-05-06", patientDto.getDischargeDay().toString());

    }

}