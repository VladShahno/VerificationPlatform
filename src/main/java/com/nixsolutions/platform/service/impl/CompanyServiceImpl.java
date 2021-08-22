package com.nixsolutions.platform.service.impl;

import com.nixsolutions.platform.persistence.entity.Company;
import com.nixsolutions.platform.persistence.repository.CompanyRepository;
import com.nixsolutions.platform.service.CompanyService;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void create(Company company) {
        if (!companyRepository.existsByCompanyName(company.getCompanyName())) {
            companyRepository.save(company);
        } else
            throw new RuntimeException("Company with name - " + company.getCompanyName() + " already exists!");
    }

    @Override
    public void update(Company company) {
        if (companyRepository.existsById(company.getId())) {
            if (companyRepository.existsByCompanyName(company.getCompanyName())) {
                companyRepository.save(company);
            } else
                throw new RuntimeException("Company with name - " + company.getCompanyName() + " does not exist!");
        } else
            throw new RuntimeException("Company with id - " + company.getId() + " does not exist!");
    }

    @Override
    public void delete(Integer id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
        } else
            throw new RuntimeException("Company with id - " + id + " does not exist!");
    }

    @Override
    public Company find(Integer id) {
        if (companyRepository.existsById(id)) {
            return companyRepository.getById(id);
        } else
            throw new RuntimeException("Company with id - " + id + " does not exist!");
    }

    @Override
    public Page<Company> find(Map<String, String> params) {
        return null;
    }
}
