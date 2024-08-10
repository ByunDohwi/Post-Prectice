package org.example.bebyundohwi.week1.global.security.jwt.refresh.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class RefreshToken {
    @Id
    private String accountId;

    @Indexed
    private String token;


    public void updateToken(String token, long ttl) {
        this.token = token;
    }
}
