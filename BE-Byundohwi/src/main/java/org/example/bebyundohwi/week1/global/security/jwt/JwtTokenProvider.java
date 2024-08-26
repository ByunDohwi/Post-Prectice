package org.example.bebyundohwi.week1.global.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.global.security.role.Role;
import org.example.bebyundohwi.week1.global.security.auth.AdminDetailService;
import org.example.bebyundohwi.week1.global.security.auth.AuthDetailsService;
import org.example.bebyundohwi.week1.global.security.exception.InvalidTokenException;
import org.example.bebyundohwi.week1.global.security.jwt.dto.TokenResponse;
import org.example.bebyundohwi.week1.global.security.jwt.refresh.RefreshTokenRepository;
import org.example.bebyundohwi.week1.global.security.jwt.refresh.domain.RefreshToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Claims;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final RefreshTokenRepository refreshTokenRepository;
    private final AuthDetailsService authDetailsService;
    private final AdminDetailService adminDetailService;
    private final JwtProperty jwtProperty;

    private static final String ACCESS_TOKEN = "access_token";
    private static final String REFRESH_TOKEN = "refresh_token";

    public TokenResponse generateToken(String id, String role) {
        String accessToken = generateToken(id, ACCESS_TOKEN, role, jwtProperty.getAccessExp());
        LocalDateTime accessExpiredAt = LocalDateTime.now().withNano(0).plusSeconds(jwtProperty.getAccessExp());
        String refreshToken = generateToken(id, REFRESH_TOKEN, role, jwtProperty.getRefreshExp());
        LocalDateTime refreshExpiredAt = LocalDateTime.now().withNano(0).plusSeconds(jwtProperty.getRefreshExp());

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .username(id)
                        .token(refreshToken)
                        .build()
        );

        return new TokenResponse(accessToken, refreshToken, accessExpiredAt, refreshExpiredAt);
    }


    private String generateToken(String id, String type, String role, Long exp) {
        return Jwts.builder()
                .setSubject(id)
                .setHeaderParam("typ", type)
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS256, jwtProperty.getJwtSecret())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .setIssuedAt(new Date())
                .compact();

    }

    public String resolveToken(HttpServletRequest request) {
        String token = request.getHeader(jwtProperty.getHeader());
        if (token != null && token.startsWith(jwtProperty.getPrefix()) && token.length() > jwtProperty.getPrefix().length() + 1) {
            return token.substring(jwtProperty.getPrefix().length() + 1);
        } else {
            return null;
        }
    }

    public boolean validToken(String token) {
        //return  (LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() > getJws(token).getBody().getExpiration().getTime());
        //return LocalDateTime.now().isAfter((LocalDateTime)(getJws(token).getBody().get("exp")));
        try {
            Jwts.parser()
                    .setSigningKey(jwtProperty.getJwtSecret())
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Authentication authentication(String token) {
        Claims body = getJws(token).getBody();

        boolean isNotRefreshToken = REFRESH_TOKEN.equals(getJws(token).getHeader().get("typ").toString());
        if (isNotRefreshToken) throw InvalidTokenException.EXCEPTION;

        UserDetails userDetails = getDetails(body);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Jws<Claims> getJws(String token) {
        //jwtToken을 불러와 Claim의 형식으로 반환한다.
        try {
            return Jwts.parser().setSigningKey(jwtProperty.getJwtSecret()).parseClaimsJws(token);
        } catch (Exception e) {
            throw e;
        }
    }

    private UserDetails getDetails(Claims body) {
        if (body.get("role").equals(Role.USER.toString())) {
            return authDetailsService.loadUserByUsername(body.getSubject());
        }else{
            return adminDetailService.loadUserByUsername(body.getSubject());
        }
    }
}
