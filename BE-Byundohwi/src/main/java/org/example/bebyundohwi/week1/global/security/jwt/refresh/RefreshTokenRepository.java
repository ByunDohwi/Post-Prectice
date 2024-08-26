package org.example.bebyundohwi.week1.global.security.jwt.refresh;


import org.example.bebyundohwi.week1.global.security.jwt.refresh.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByToken(String token);
}
