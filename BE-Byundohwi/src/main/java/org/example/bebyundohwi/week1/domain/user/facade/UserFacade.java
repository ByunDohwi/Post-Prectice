package org.example.bebyundohwi.week1.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.example.bebyundohwi.week1.domain.user.domain.UserEntity;
import org.example.bebyundohwi.week1.domain.user.exception.UserNotFoundException;
import org.example.bebyundohwi.week1.domain.user.repository.UserRepository;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;

    public UserEntity getUserByUserName(String userName) {
        return userRepository.findByUsername(userName).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public UserEntity getCurrentUser() {
         return getUserByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->UserNotFoundException.EXCEPTION);
    }
}
