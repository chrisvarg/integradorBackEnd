package com.cvargas.dentalOffice.dentalOffice.service;

import com.cvargas.dentalOffice.dentalOffice.dto.AddressDto;
import com.cvargas.dentalOffice.dentalOffice.model.Address;

import java.util.List;

public interface IAddressService {
    public AddressDto create(Address address);
    AddressDto read(Integer id);
    List<AddressDto> readAll();
    void delete(Integer id);
}
