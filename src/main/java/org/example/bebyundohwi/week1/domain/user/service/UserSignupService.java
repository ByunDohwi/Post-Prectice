package org.example.bebyundohwi.week1.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.global.security.role.Role;
import org.example.bebyundohwi.week1.domain.user.dto.request.UserLoginRequest;
import org.example.bebyundohwi.week1.domain.user.domain.UserEntity;
import org.example.bebyundohwi.week1.domain.user.dto.request.UserSignupRequest;
import org.example.bebyundohwi.week1.domain.user.repository.UserRepository;
import org.example.bebyundohwi.week1.global.security.jwt.dto.TokenResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor

public class UserSignupService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final UserLoginService userLoginService;

    public TokenResponse userSignUpService(UserSignupRequest userSignupRequest) {

        userSave(userSignupRequest);
        return userLoginService.login(new UserLoginRequest(userSignupRequest));
    }

    @Transactional
    public void userSave(UserSignupRequest userSignupRequest) {
        Boolean checkAlreadyUserName = repository.existsByUsername(userSignupRequest.getUsername());
        if (!checkAlreadyUserName) {
            {
                repository.save(
                        UserEntity.builder()
                                .password(passwordEncoder.encode(userSignupRequest.getPassword()))
                                .date((LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyy.MM.dd")))
                                .email(userSignupRequest.getEmail())
                                .address(userSignupRequest.getAddress())
                                .phone(userSignupRequest.getPhone())
                                .role(Role.USER)
                                .username(userSignupRequest.getUsername())
                                .build()
                );
            }
        }
    }
}

