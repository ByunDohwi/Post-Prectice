package org.example.bebyundohwi.week1.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.user.exception.AccountIdAlreadyExistException;
import org.example.bebyundohwi.week1.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Service
@RequiredArgsConstructor
public class AccountIdDuplicateService {
    private final UserRepository userRepository;

    @Transactional
    public void checkAccountIdDuplicate(String accountId) {
        if (userRepository.existsByUsername(accountId)) {
            throw AccountIdAlreadyExistException.EXCEPTION;
        }
    }
}
