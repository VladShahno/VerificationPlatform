package com.nixsolutions.platform.facade;

import com.nixsolutions.platform.web.data.LeadData;
import com.nixsolutions.platform.web.data.PageData;
import org.springframework.web.context.request.WebRequest;

public interface LeadFacade extends BasicFacade<LeadData>{

    @Override
    void create(LeadData leadData);

    @Override
    void update(LeadData leadData);

    @Override
    void delete(Integer id);

    @Override
    LeadData find(Integer id);

    @Override
    PageData<LeadData> find(WebRequest request);
}
