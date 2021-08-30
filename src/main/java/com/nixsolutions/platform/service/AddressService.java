package com.nixsolutions.platform.service;

import com.nixsolutions.platform.persistence.entity.Address;
import org.springframework.data.domain.Page;

import java.util.Map;

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
