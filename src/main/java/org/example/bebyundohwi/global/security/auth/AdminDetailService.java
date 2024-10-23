package org.example.bebyundohwi.week1.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.admin.entity.AdminEntity;
import org.example.bebyundohwi.week1.domain.admin.repository.AdminRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminDetailService implements UserDetailsService {
    private final AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String adminName) throws UsernameNotFoundException {
        AdminEntity admin = adminRepository.findByAdminName(adminName).orElseThrow(() -> new RuntimeException("AdminDetailService.loadByUsername"));
        return new AdminDetails(admin);
    }
}
