package com.nixsolutions.platform.facade;

import com.nixsolutions.platform.web.data.CompanyData;
import com.nixsolutions.platform.web.data.PageData;
import org.springframework.web.context.request.WebRequest;

public interface CompanyFacade extends BasicFacade<CompanyData> {

    @Override
    void create(CompanyData companyData);

    @Override
    void update(CompanyData companyData);

    @Override
    void delete(Integer id);

    @Override
    CompanyData find(Integer id);

    @Override
    PageData<CompanyData> find(WebRequest request);
}
