package com.nixsolutions.platform.persistence.repository;

import com.nixsolutions.platform.persistence.entity.Lead;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {

    boolean existsByEmail(String email);
}
