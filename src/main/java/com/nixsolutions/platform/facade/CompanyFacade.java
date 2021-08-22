package com.nixsolutions.platform.facade;

import com.nixsolutions.platform.web.data.CompanyData;

public interface CompanyFacade extends BasicFacade<CompanyData> {

    @Override
    void create(CompanyData companyData);

    @Override
    void update(CompanyData companyData);

    @Override
    void delete(Integer id);

    @Override
    CompanyData find(Integer id);
}
