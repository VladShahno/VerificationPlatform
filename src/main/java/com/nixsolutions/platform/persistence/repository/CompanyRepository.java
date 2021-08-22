package com.nixsolutions.platform.persistence.repository;

import com.nixsolutions.platform.persistence.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    boolean existsByCompanyName(String name);
}
