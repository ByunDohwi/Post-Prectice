package org.example.bebyundohwi.week1.global.security.jwt.refresh.domain;


import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.data.annotation.Id;


@Builder
@Getter
@RedisHash(value = "refresh-token")
public class RefreshToken {
    @Id//anota
    private final String id;

    @Indexed
    private String token;

    @TimeToLive
    private long ttl;
    public void updateToken(String token, long ttl)
    {
        this.ttl = ttl;
        this.token = token;
    }
}
