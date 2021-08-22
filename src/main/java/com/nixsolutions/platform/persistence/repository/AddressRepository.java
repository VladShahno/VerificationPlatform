package com.nixsolutions.platform.persistence.repository;

import com.nixsolutions.platform.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
