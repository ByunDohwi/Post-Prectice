package org.example.bebyundohwi.week1.domain.admin.service;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.admin.dto.request.AdminSignupRequest;
import org.example.bebyundohwi.week1.domain.admin.entity.AdminEntity;
import org.example.bebyundohwi.week1.domain.admin.repository.AdminRepository;
import org.example.bebyundohwi.week1.domain.user.domain.role.Role;
import org.example.bebyundohwi.week1.global.security.jwt.dto.TokenResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminSignupService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(AdminSignupRequest request) {
        AdminEntity admin = AdminEntity.builder()
                .adminName(request.getAdminName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN.getRole())
                .build();

        adminRepository.save(admin);
    }
}
