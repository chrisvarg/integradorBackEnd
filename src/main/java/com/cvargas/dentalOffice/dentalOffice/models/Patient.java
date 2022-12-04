package com.cvargas.dentalOffice.dentalOffice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patient {

    private int id;
    private String name;
    private String lastName;
    private String DNI;
    private LocalDateTime dischargeDay;
    private Address address;

    public Patient(String name, String lastName, String DNI, LocalDateTime dischargeDay, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
        this.dischargeDay = dischargeDay;
        this.address = address;
    }
}
