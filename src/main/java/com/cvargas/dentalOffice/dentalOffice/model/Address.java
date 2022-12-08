package com.cvargas.dentalOffice.dentalOffice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    // comparte el generador con dentist
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String street;
    @Column
    private int number;
    @Column
    private String location;
    @Column
    private String province;

    @OneToOne(mappedBy = "address")
    @JsonIgnore // Todo: Profe si no lo añado y llamo todos los pacientes genera un recursion infinita, esto lo evita
    private Patient patient;

    public Address(Long id, String street, int number, String location, String province) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.location = location;
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", location='" + location + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
