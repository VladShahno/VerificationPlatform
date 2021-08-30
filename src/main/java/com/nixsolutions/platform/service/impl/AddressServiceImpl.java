package com.nixsolutions.platform.service.impl;

import com.nixsolutions.platform.persistence.entity.Address;
import com.nixsolutions.platform.persistence.repository.AddressRepository;
import com.nixsolutions.platform.service.AddressService;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void create(Address address) {
        if (!addressRepository.existsById(address.getId())) {
            addressRepository.save(address);
        } else
            throw new RuntimeException("Address with id - " + address.getId() + " already exists!");
    }

    @Override
    public void update(Address address) {
        if (addressRepository.existsById(address.getId())) {
            addressRepository.save(address);
        } else
            throw new RuntimeException("Address with id - " + address.getId() + " already exists!");
    }

    @Override
    public void delete(Integer id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
        } else
            throw new RuntimeException("Address with id - " + id + " does not exist!");
    }

    @Override
    public Address find(Integer id) {
        if (addressRepository.existsById(id)) {
            return addressRepository.getById(id);
        } else
            throw new RuntimeException("Address with id - " + id + " does not exist!");
    }
}
