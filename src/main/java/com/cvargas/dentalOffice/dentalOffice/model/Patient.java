package com.cvargas.dentalOffice.dentalOffice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id

    //@SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)

    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Long id;
    @Column
    private String lastname;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private int DNI;
    @Column
    private LocalDate dischargeDay;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Turn> turnos;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", DNI=" + DNI +
                ", dischargeDay=" + dischargeDay +
                ", address=" + address +
                ", turnos=" + turnos +
                '}';
    }
}

