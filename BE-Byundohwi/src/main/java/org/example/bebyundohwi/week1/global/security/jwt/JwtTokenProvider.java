package org.example.bebyundohwi.week1.global.security.jwt;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.global.security.jwt.refresh.RefreshTokenRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final RefreshTokenRepository refreshTokenRepository;
}
