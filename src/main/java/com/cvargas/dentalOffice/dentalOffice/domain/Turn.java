package com.cvargas.dentalOffice.dentalOffice.domain;

import com.cvargas.dentalOffice.dentalOffice.model.Dentist;
import com.cvargas.dentalOffice.dentalOffice.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Turn {

    private int id;
    private Dentist dentist;
    private Patient patient;
    private LocalDate date;



    public String infoTurn() {

        StringBuilder message = new StringBuilder("Paciente: " + this.patient.getName()  + " " + this.patient.getLastName());
        message.append("\n").append("Odontologo: " + this.dentist.getName() + " " + this.dentist.getLastName()).append("\n");
        message.append("Fecha: " + date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear());

        return message.toString();
    }
}
