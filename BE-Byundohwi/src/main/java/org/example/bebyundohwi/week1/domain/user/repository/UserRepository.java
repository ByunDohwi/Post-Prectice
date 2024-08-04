package org.example.bebyundohwi.week1.domain.user.repository;

import org.example.bebyundohwi.week1.domain.user.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
    Boolean existsByUsername(String username);
}
