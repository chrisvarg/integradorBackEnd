package com.cvargas.dentalOffice.dentalOffice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patient {

    private int id;
    private String name;
    private String lastName;

    private String email;
    private String DNI;
    private LocalDate dischargeDay;
    private Address address;

    public Patient(String name, String lastName, String email, String DNI, LocalDate dischargeDay, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.DNI = DNI;
        this.dischargeDay = dischargeDay;
        this.address = address;
    }
}
