package com.nixsolutions.platform.facade;

import com.nixsolutions.platform.web.data.AddressData;

public interface AddressFacade extends BasicFacade<AddressData>{

    @Override
    void create(AddressData addressData);

    @Override
    void update(AddressData addressData);

    @Override
    void delete(Integer id);

    @Override
    AddressData find(Integer id);
}
