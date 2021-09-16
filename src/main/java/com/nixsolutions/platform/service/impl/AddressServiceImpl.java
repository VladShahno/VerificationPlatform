package com.nixsolutions.platform.service.impl;

import com.nixsolutions.platform.persistence.entity.Address;
import com.nixsolutions.platform.persistence.repository.AddressRepository;
import com.nixsolutions.platform.service.AddressService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private static final Logger log = LoggerFactory.getLogger("log");

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void create(Address address) {
        if (!addressRepository.existsById(address.getId())) {
            log.info("Creating of address with id - " + address.getId());
            addressRepository.save(address);
            log.info("The address was created!");
        } else
            throw new RuntimeException("Address with id - " + address.getId() + " already exists!");
    }

    @Override
    public void update(Address address) {
        if (addressRepository.existsById(address.getId())) {
            log.info("Updating of address with id - " + address.getId());
            addressRepository.save(address);
            log.info("The address was updated!");
        } else
            throw new RuntimeException("Address with id - " + address.getId() + " does not exist!");
    }

    @Override
    public void delete(Integer id) {
        if (addressRepository.existsById(id)) {
            log.warn("Deleting of address with id - " + id);
            addressRepository.deleteById(id);
            log.warn("The address was deleted!");
        } else
            throw new RuntimeException("Address with id - " + id + " does not exist!");
    }

    @Override
    public Address find(Integer id) {
        if (addressRepository.existsById(id)) {
            log.info("Finding of address with id - " + id);
            return addressRepository.getById(id);
        } else
            throw new RuntimeException("Address with id - " + id + " does not exist!");
    }
}
