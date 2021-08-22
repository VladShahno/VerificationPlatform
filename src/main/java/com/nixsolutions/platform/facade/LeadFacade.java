package com.nixsolutions.platform.facade;

import com.nixsolutions.platform.web.data.LeadData;

public interface LeadFacade extends BasicFacade<LeadData>{

    @Override
    void create(LeadData leadData);

    @Override
    void update(LeadData leadData);

    @Override
    void delete(Integer id);

    @Override
    LeadData find(Integer id);
}
