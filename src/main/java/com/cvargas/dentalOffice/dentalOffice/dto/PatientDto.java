package com.cvargas.dentalOffice.dentalOffice.dto;

import com.cvargas.dentalOffice.dentalOffice.domain.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PatientDto {

    private int id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate dischargeDay;
    private Address address;

    @Override
    public String toString() {
        return "PatientDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dischargeDay=" + dischargeDay +
                ", address=" + address +
                '}';
    }
}
