package com.cvargas.dentalOffice.dentalOffice.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turn {

    private Dentist dentist;
    private Patient patient;
    private LocalDate date;
    private LocalTime hour;

    public Turn() {
    }

    public Turn(Dentist dentist, Patient patient, LocalDate date, LocalTime hour) {
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
        this.hour = hour;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public String infoTurn() {

        StringBuilder message = new StringBuilder("Paciente: " + this.patient.getName()  + " " + this.patient.getLastName());
        message.append("\n").append("Odontologo: " + this.dentist.getName() + " " + this.dentist.getLastName()).append("\n");
        message.append("Fecha: " + date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear() + " - "  + hour.toString());

        return message.toString();
    }
}
