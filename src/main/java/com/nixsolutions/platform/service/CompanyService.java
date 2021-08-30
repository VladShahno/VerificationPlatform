package com.nixsolutions.platform.service;

import com.nixsolutions.platform.persistence.entity.Company;
import org.springframework.data.domain.Page;

import java.util.Map;

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
