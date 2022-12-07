package com.cvargas.dentalOffice.dentalOffice.service.impl;

import com.cvargas.dentalOffice.dentalOffice.dto.AddressDto;
import com.cvargas.dentalOffice.dentalOffice.model.Address;
import com.cvargas.dentalOffice.dentalOffice.repository.AddressRepository;
import com.cvargas.dentalOffice.dentalOffice.service.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {


    private AddressRepository addressRepository;
    private ObjectMapper mapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, ObjectMapper mapper) {
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }

    @Override
    public AddressDto create(Address address) {

        addressRepository.save(address);
        System.out.println(address);
        return mapper.convertValue(address, AddressDto.class);
    }

    @Override
    public AddressDto read(Integer id) {
        Optional<Address> address = addressRepository.findById(Long.valueOf(id));
        System.out.println(address);
        System.out.println((mapper.convertValue(address, AddressDto.class)));
        return (mapper.convertValue(address, AddressDto.class));
    }

    @Override
    public List<AddressDto> readAll() {
        List<Address> addressList = addressRepository.findAll();
        List<AddressDto> addressDtoList = new ArrayList<>();
        addressList.forEach(address -> addressDtoList.add(mapper.convertValue(address, AddressDto.class)));
        addressDtoList.forEach(System.out::println);
        return addressDtoList;
    }

    @Override
    public void delete(Integer id) {
        addressRepository.deleteById(Long.valueOf(id));
    }
}
