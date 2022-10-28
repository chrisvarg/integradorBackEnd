package com.cvargas.dentaoffice.models;

import java.time.LocalDateTime;

public class Patient {

    private int id;
    private String name;
    private String lastName;
    private String address;
    private String DNI;
    private LocalDateTime dischargeDay;

    public Patient() {
    }


    public Patient(int id, String name, String lastName, String address, String DNI) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.DNI = DNI;
    }

    public Patient(int id, String name, String lastName, String address, String DNI, LocalDateTime dischargeDay) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.DNI = DNI;
        this.dischargeDay = dischargeDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public LocalDateTime getDischargeDay() {
        return dischargeDay;
    }

    public void setDischargeDay(LocalDateTime dischargeDay) {
        this.dischargeDay = dischargeDay;
    }
}
