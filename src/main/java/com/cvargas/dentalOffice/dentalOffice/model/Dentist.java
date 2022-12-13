package com.cvargas.dentalOffice.dentalOffice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dentists")
public class Dentist {

    @Id
    @SequenceGenerator(name = "dentist_sequence", sequenceName = "dentist_sequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "dentist_sequence")
    private Long id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String license;

    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turn> turns = new HashSet<>();

    public Dentist(Long id, String name, String lastName, String license) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.license = license;
    }
}
