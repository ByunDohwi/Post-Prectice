package org.example.bebyundohwi.week1.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.user.domain.role.Role;
import org.example.bebyundohwi.week1.domain.user.exception.UserNameAlreadyExistException;
import org.example.bebyundohwi.week1.domain.user.domain.UserEntity;
import org.example.bebyundohwi.week1.domain.user.dto.request.UserSignupRequest;
import org.example.bebyundohwi.week1.domain.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor

public class UserSignupService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    public void userSignUpService(UserSignupRequest userSignupRequest) {
        Boolean checkAlreadyUserName = repository.existsByUsername(userSignupRequest.getUsername());

        if(!checkAlreadyUserName) {
            {
                repository.save(
                        UserEntity.builder()
                                .password(passwordEncoder.encode(userSignupRequest.getPassword()))
                                .createDate((LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyy.MM.dd")))
                                .email(userSignupRequest.getEmail())
                                .address(userSignupRequest.getAddress())
                                .phone(userSignupRequest.getPhone())
                                .role(Role.USER)
                                .username(userSignupRequest.getUsername())
                                .build()
                );
            }
        }else{
            throw UserNameAlreadyExistException.EXCEPTION;
        }
    }
}
