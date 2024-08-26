package org.example.bebyundohwi.week1.domain.admin.repository;

import org.example.bebyundohwi.week1.domain.admin.entity.AdminEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminRepository extends CrudRepository<AdminEntity,Long> {
    Optional<AdminEntity> findByAdminName(String adminName);
}
