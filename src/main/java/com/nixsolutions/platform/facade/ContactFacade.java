package com.nixsolutions.platform.facade;

import com.nixsolutions.platform.web.dto.LeadDto;
import com.nixsolutions.platform.web.dto.PageData;
import org.springframework.web.context.request.WebRequest;

public interface ContactFacade extends BasicFacade<LeadDto> {

    @Override
    void create(LeadDto leadDto);

    @Override
    void update(LeadDto leadDto);

    @Override
    void delete(Integer id);

    @Override
    LeadDto find(Integer id);

    @Override
    PageData<LeadDto> find(WebRequest request);
}
