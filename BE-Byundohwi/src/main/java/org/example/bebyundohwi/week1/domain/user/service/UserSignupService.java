package org.example.bebyundohwi.week1.domain.user.service;

import org.example.bebyundohwi.week1.domain.user.domain.UserEntity;
import org.example.bebyundohwi.week1.domain.user.dto.request.UserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserSignupService {
    public void userSignUpService(UserRequest userRequest) {
        UserEntity user = UserEntity.builder()
    }
}
