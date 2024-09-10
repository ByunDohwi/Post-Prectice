package org.example.bebyundohwi.week1.global.exception.security.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class TokenResponse {//record로 변환가능..?.?
    private final String accessToken;
    private final String refreshToken;
    private final LocalDateTime accessExpiredAt;
    private final LocalDateTime refreshExpiredAt;

}
