package com.nixsolutions.platform.service;

import com.nixsolutions.platform.persistence.entity.Company;

public interface CompanyService extends BasicCrudService<Company> {

    @Override
    void create(Company company);

    @Override
    void update(Company company);

    @Override
    void delete(Integer id);

    @Override
    Company find(Integer id);
}
