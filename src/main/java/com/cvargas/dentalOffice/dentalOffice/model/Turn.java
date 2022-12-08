package com.cvargas.dentalOffice.dentalOffice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "turns")
public class Turn {

    @Id
    @SequenceGenerator(name = "turn_sequence", sequenceName = "turn_sequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "turn_sequence")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
    @Column
    private LocalDate date;


    @Override
    public String toString() {
        return "Turn{" +
                "id=" + id +
                ", patient=" + patient +
                ", dentist=" + dentist +
                ", date=" + date +
                '}';
    }

    public String infoTurn() {

        StringBuilder message = new StringBuilder("Paciente: " + this.patient.getName()  + " " + this.patient.getLastName());
        message.append("\n").append("Odontologo: " + this.dentist.getName() + " " + this.dentist.getLastName()).append("\n");
        message.append("Fecha: " + date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear());

        return message.toString();
    }
}
