package com.cvargas.dentalOffice.dentalOffice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Dentist dentist;

    private LocalDate date;

}
