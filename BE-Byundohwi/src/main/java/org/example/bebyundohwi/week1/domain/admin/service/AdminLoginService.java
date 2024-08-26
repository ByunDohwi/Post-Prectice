package org.example.bebyundohwi.week1.domain.admin.service;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.admin.dto.request.AdminSignupRequest;
import org.example.bebyundohwi.week1.domain.admin.entity.AdminEntity;
import org.example.bebyundohwi.week1.domain.admin.exception.AdminMissMatchException;
import org.example.bebyundohwi.week1.domain.admin.repository.AdminRepository;
import org.example.bebyundohwi.week1.domain.user.exception.UserNotFoundException;
import org.example.bebyundohwi.week1.global.security.jwt.JwtTokenProvider;
import org.example.bebyundohwi.week1.global.security.jwt.dto.TokenResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminLoginService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    public TokenResponse login(AdminSignupRequest request) {
        AdminEntity admin = adminRepository.findByAdminName(request.getAdminName()).orElseThrow(() -> UserNotFoundException.EXCEPTION);
        if (passwordEncoder.matches(admin.getPassword(), request.getPassword())) {
            return jwtTokenProvider.generateToken(request.getAdminName(), admin.getRole());
        }
        else {
            throw AdminMissMatchException.EXCEPTION;
        }
    }
}
