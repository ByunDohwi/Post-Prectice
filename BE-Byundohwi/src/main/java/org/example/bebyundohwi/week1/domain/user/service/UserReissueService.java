package org.example.bebyundohwi.week1.domain.user.service;


import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.user.domain.UserEntity;
import org.example.bebyundohwi.week1.domain.user.repository.UserRepository;
import org.example.bebyundohwi.week1.global.security.jwt.JwtProperty;
import org.example.bebyundohwi.week1.global.security.jwt.JwtTokenProvider;
import org.example.bebyundohwi.week1.global.security.jwt.dto.TokenResponse;
import org.example.bebyundohwi.week1.global.security.jwt.refresh.RefreshTokenRepository;
import org.example.bebyundohwi.week1.global.security.jwt.refresh.domain.RefreshToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserReissueService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final JwtProperty jwtProperty;

    public TokenResponse reissue(String token) {
        boolean isTokenInvalid = !jwtTokenProvider.validToken(token);
        if(isTokenInvalid){
                throw new RuntimeException("여긴가제발");
        }
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token).orElseThrow(()->new RuntimeException("존재하지 않는 토큰"));
        UserEntity user = userRepository.findByUsername(refreshToken.getUsername()).orElseThrow();
        return jwtTokenProvider.generateToken(user.getUsername(),user.getRole().toString());
    }
}
