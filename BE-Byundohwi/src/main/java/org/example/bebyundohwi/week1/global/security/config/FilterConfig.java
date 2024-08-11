package org.example.bebyundohwi.week1.global.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.global.filter.ExceptionFilter;
import org.example.bebyundohwi.week1.global.filter.JWTokenFilter;
import org.example.bebyundohwi.week1.global.security.jwt.JwtTokenProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final ObjectMapper objectMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        JWTokenFilter jwTokenFilter = new JWTokenFilter(jwtTokenProvider);
        ExceptionFilter exceptionFilter = new ExceptionFilter(objectMapper);
        builder.addFilterBefore(jwTokenFilter, UsernamePasswordAuthenticationFilter.class);
        builder.addFilterBefore(exceptionFilter, JWTokenFilter.class);
    }
}
