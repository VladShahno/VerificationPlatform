package com.nixsolutions.platform.service.impl;

import com.nixsolutions.platform.persistence.entity.Company;
import com.nixsolutions.platform.persistence.repository.CompanyRepository;
import com.nixsolutions.platform.service.CompanyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private static final Logger log = LoggerFactory.getLogger("log");

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void create(Company company) {
        if (!companyRepository.existsByCompanyName(company.getCompanyName())) {
            log.info("Creating of company with id - " + company.getId());
            companyRepository.save(company);
            log.info("The company was created!");
        } else
            throw new RuntimeException("Company with name - " + company.getCompanyName() + " already exists!");
    }

    @Override
    public void update(Company company) {
        if (companyRepository.existsById(company.getId())) {
                log.info("Updating of company with id - " + company.getId());
                companyRepository.save(company);
                log.info("The company was updated!");
            } else
                throw new RuntimeException("Company with name - " + company.getCompanyName() + " does not exist!");
    }

    @Override
    public void delete(Integer id) {
        if (companyRepository.existsById(id)) {
            log.warn("Deleting of company with id - " + id);
            companyRepository.deleteById(id);
            log.warn("The company was deleted!");
        } else
            throw new RuntimeException("Company with id - " + id + " does not exist!");
    }

    @Override
    public Company find(Integer id) {
        if (companyRepository.existsById(id)) {
            log.info("Finding of company with id - " + id);
            return companyRepository.getById(id);
        } else
            throw new RuntimeException("Company with id - " + id + " does not exist!");
    }
}
