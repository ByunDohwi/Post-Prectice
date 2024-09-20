package org.example.bebyundohwi.week1.global.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@Slf4j
@RequiredArgsConstructor
public class RedisService {
    private final RedisTemplate<String, String> redisTemplate;

    // get RefreshToken
    public String getRefreshToken(String id) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        // RefreshToken 없으면 null 반환
        return valueOperations.get(id);
    }

    // delete RefreshToken
    public void deleteRefreshToken(String refreshToken) {
        // delete 메서드 삭제 시 true 반환
        redisTemplate.delete(refreshToken);
    }
}
