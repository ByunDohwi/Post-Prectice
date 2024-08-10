package org.example.bebyundohwi.week1.domain.user.repository;

import org.example.bebyundohwi.week1.domain.user.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
    Boolean existsByUsername(String username);

    Optional<UserEntity> findByUsername(String userName);
}
