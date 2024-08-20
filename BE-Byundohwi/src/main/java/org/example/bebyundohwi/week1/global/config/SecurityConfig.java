package org.example.bebyundohwi.week1.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.global.filter.ExceptionFilter;
import org.example.bebyundohwi.week1.global.filter.JWTokenFilter;
import org.example.bebyundohwi.week1.global.security.jwt.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final ObjectMapper objectMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
         http
                .csrf(CsrfConfigurer::disable)
                .cors(Customizer.withDefaults())
                .sessionManagement(configurer->configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/user/signup","/user/duplicate/","/user/login","/user/reissue","admin/signup").permitAll()
                                .requestMatchers("/user/haha").hasRole("USER")
                                .anyRequest().authenticated()
                )
                 .addFilterBefore(new JWTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                 .addFilterBefore(new ExceptionFilter(objectMapper), JWTokenFilter.class);

         return http.build();
    }
}
