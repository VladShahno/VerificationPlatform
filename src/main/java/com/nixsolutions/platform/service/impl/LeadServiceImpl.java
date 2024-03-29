package com.nixsolutions.platform.service.impl;

import com.nixsolutions.platform.persistence.entity.Lead;
import com.nixsolutions.platform.persistence.repository.LeadRepository;
import com.nixsolutions.platform.service.LeadService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static com.nixsolutions.platform.util.WebRequestUtil.*;

import java.util.Map;

@Service
public class LeadServiceImpl implements LeadService {

    private static final Logger log = LoggerFactory.getLogger("log");

    private final LeadRepository leadRepository;

    public LeadServiceImpl(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    @Override
    public void create(Lead lead) {
        if (!leadRepository.existsByEmail(lead.getEmail())) {
            log.info("Creating of lead with email - " + lead.getEmail());
            leadRepository.save(lead);
            log.info("The lead was created!");
        } else
            throw new RuntimeException("Lead with email - " + lead.getEmail() + " already exists!");
    }

    @Override
    public void update(Lead lead) {
        if (leadRepository.existsById(lead.getId())) {
            if (leadRepository.existsByEmail(lead.getEmail())) {
                log.info("Updating of lead with email - " + lead.getEmail());
                leadRepository.save(lead);
                log.info("The lead was updated!");
            } else
                throw new RuntimeException("Lead with email - " + lead.getEmail() + " does not exist!");
        } else
            throw new RuntimeException("Lead with id - " + lead.getId() + " does not exist!");
    }

    @Override
    public void delete(Integer id) {
        if (leadRepository.existsById(id)) {
            log.warn("Deleting of lead with id - " + id);
            leadRepository.deleteById(id);
            log.warn("The lead was deleted!");
        } else
            throw new RuntimeException("Lead with id - " + id + " does not exist!");
    }

    @Override
    public Lead find(Integer id) {
        if (leadRepository.existsById(id)) {
            log.info("Finding of lead with id - " + id);
            return leadRepository.getById(id);
        }
        throw new RuntimeException("Lead with id - " + id + " does not exist!");
    }

    @Override
    public Page<Lead> find(Map<String, String> params) {
        int page = Integer.parseInt(params.get(PAGE_PARAM));
        int size = Integer.parseInt(params.get(SIZE_PARAM));
        String order = params.get(ORDER_PARAM);
        String sort = params.get(SORT_PARAM);
        if (order.equals(DEFAULT_ORDER_PARAM_VALUE)) {
            return leadRepository.findAll(PageRequest.of(page - 1, size, Sort.by(Sort.Order.desc(sort))));
        }
        return leadRepository.findAll(PageRequest.of(page - 1, size, Sort.by(Sort.Order.asc(sort))));
    }
}
