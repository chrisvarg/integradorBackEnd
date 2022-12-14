package com.cvargas.dentalOffice.dentalOffice.dto;

import com.cvargas.dentalOffice.dentalOffice.model.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class PatientDto {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private LocalDate dischargeDay;
    private Address address;

    @Override
    public String toString() {
        return "PatientDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", dischargeDay=" + dischargeDay +
                ", address=" + address +
                '}';
    }
}
