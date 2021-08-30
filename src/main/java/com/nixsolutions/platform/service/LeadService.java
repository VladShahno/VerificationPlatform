package com.nixsolutions.platform.service;

import com.nixsolutions.platform.persistence.entity.Lead;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface LeadService extends BasicCrudService<Lead> {

    @Override
    void create(Lead lead);

    @Override
    void update(Lead lead);

    @Override
    void delete(Integer id);

    @Override
    Lead find(Integer id);

    Page<Lead> find(Map<String, String> params);
}
