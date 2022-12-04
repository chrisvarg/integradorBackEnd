package com.cvargas.dentalOffice.dentalOffice.service;

import com.cvargas.dentalOffice.dentalOffice.dao.AddressDaoH2;
import com.cvargas.dentalOffice.dentalOffice.dto.DentistDto;
import com.cvargas.dentalOffice.dentalOffice.models.Address;
import com.cvargas.dentalOffice.dentalOffice.models.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    AddressDaoH2 addressDaoH2;

    @Autowired
    public AddressService(AddressDaoH2 addressDaoH2) {
        this.addressDaoH2 = addressDaoH2;
    }

    public Address create(Address address) {
        return addressDaoH2.create(address);
    }

    public List<Address> readAll() {
        return addressDaoH2.readAll();
    }

    public Address read(int id) {
        return addressDaoH2.read(id);
    }
    public void update(Address address) {
        addressDaoH2.update(address);
    }

    public void delete(Integer id) {
        addressDaoH2.delete(id);
    }
}