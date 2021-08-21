package com.nixsolutions.persistance.service;

import com.nixsolutions.persistance.entity.Company;
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

    @Override
    Page<Company> find(Map<String, String> params);
}
