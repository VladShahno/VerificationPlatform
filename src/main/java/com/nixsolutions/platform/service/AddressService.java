package com.nixsolutions.platform.service;

import com.nixsolutions.platform.persistence.entity.Address;

public interface AddressService extends BasicCrudService<Address> {

    @Override
    void create(Address address);

    @Override
    void update(Address address);

    @Override
    void delete(Integer id);

    @Override
    Address find(Integer id);
}
