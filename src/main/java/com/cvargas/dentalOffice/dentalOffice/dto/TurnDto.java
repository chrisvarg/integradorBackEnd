package com.cvargas.dentalOffice.dentalOffice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TurnDto {

    private int id;
    private DentistDto dentist;
    private PatientDto patient;
    private LocalDate date;

    @Override
    public String toString() {
        return "TurnDto{" +
                "id=" + id +
                ", dentist=" + dentist +
                ", patient=" + patient +
                ", date=" + date +
                '}';
    }
}
