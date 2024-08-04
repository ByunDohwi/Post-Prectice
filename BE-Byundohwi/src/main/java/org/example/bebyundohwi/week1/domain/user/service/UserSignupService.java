package org.example.bebyundohwi.week1.domain.user.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.user.domain.UserEntity;
import org.example.bebyundohwi.week1.domain.user.dto.request.UserRequest;
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

    public void userSignUpService(UserRequest userRequest) {
        Boolean checkAlreadyUserName = repository.existsByUsername(userRequest.getUsername());

        if(checkAlreadyUserName) {
            {
                repository.save(
                        UserEntity.builder()
                                .password(passwordEncoder.encode(userRequest.getPassword()))
                                .createDate((LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyy.MM.dd")))
                                .username(userRequest.getUsername())
                                .build()
                );
            }
        }
    }
}
