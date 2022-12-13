package com.cvargas.dentalOffice.dentalOffice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence"
            //, allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "domicilio_sequence")
    private Long id;
    @Column
    private String street;
    @Column
    private String location;
    @Column
    private String province;
    @Column
    private int number;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Patient patient;

    public Address(Long id, String street, String location, String province, int number) {
        this.id = id;
        this.street = street;
        this.location = location;
        this.province = province;
        this.number = number;
    }


}
