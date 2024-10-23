package org.example.bebyundohwi.week1.global.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.global.security.exception.InvalidTokenException;
import org.example.bebyundohwi.week1.global.security.jwt.JwtTokenProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JWTokenFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtTokenProvider.resolveToken(request);
        System.out.println("a");
        if (token != null ) {
            System.out.println("b");
            if(jwtTokenProvider.validToken(token)){
                System.out.println("c");
                Authentication authentication = jwtTokenProvider.authentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            else{
                System.out.println("d");
                throw InvalidTokenException.EXCEPTION;
            }
        }
        filterChain.doFilter(request,response);
    }
}
