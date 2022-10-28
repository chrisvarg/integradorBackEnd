package com.cvargas.dentaoffice.model;

import com.cvargas.dentaoffice.models.Dentist;
import com.cvargas.dentaoffice.models.Patient;
import com.cvargas.dentaoffice.models.Turn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

class TurnTest {

    @Test
    public void crearUnTurno() {
        // Given
        Patient paciente = new Patient(1, "Mateo", "Sanchez", "Av. 9 #89-36 barrio clara luz", "12345678");
        Dentist odontologo = new Dentist(3, "Santiago", "Aristizabal", "D001");

        Turn citaOdontologica = new Turn(odontologo, paciente, LocalDate.of(2022, 10, 15), LocalTime.of(13, 00));

        String resultadoEsperado = "Paciente: Mateo Sanchez\nOdontologo: Santiago Aristizabal\nFecha: 15/10/2022 - 13:00";

        // When
        String resultado = citaOdontologica.infoTurn();

        //Thend
        Assertions.assertEquals(resultadoEsperado, resultado);
    }

    // TODO: tests de instancias de todos los modelos.... turn, parient Dentist
}