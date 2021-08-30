package com.nixsolutions.platform.facade;

import com.nixsolutions.platform.web.data.AddressData;
import com.nixsolutions.platform.web.data.PageData;
import org.springframework.web.context.request.WebRequest;

public interface AddressFacade extends BasicFacade<AddressData>{

    @Override
    void create(AddressData addressData);

    @Override
    void update(AddressData addressData);

    @Override
    void delete(Integer id);

    @Override
    AddressData find(Integer id);

    @Override
    PageData<AddressData> find(WebRequest request);
}
