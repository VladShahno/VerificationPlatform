package com.nixsolutions.platform.persistence.repository;

import java.util.Optional;

import com.nixsolutions.platform.persistence.entity.ERole;
import com.nixsolutions.platform.persistence.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
