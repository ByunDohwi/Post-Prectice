package org.example.bebyundohwi.week1.domain.admin.controller;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.admin.dto.request.AdminSignupRequest;
import org.example.bebyundohwi.week1.domain.admin.service.AdminLoginService;
import org.example.bebyundohwi.week1.domain.admin.service.AdminSignupService;
import org.example.bebyundohwi.week1.global.security.jwt.dto.TokenResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminSignupService adminSignupService;
    private final AdminLoginService adminLoginService;

    @PostMapping("/signup")
    public void signup(@RequestBody AdminSignupRequest request) {
        adminSignupService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody AdminSignupRequest request) {
        return adminLoginService.login(request);
    }

    @GetMapping("/sayMyName")
    public String sayMyName() {
        return "Hello" + SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
