package org.example.bebyundohwi.week1.domain.admin.controller;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.admin.dto.request.AdminSignupRequest;
import org.example.bebyundohwi.week1.domain.admin.service.AdminSignupService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminSignupService adminSignupService;

    @PostMapping("/signup")
    public void signup(@RequestBody AdminSignupRequest request) {
        adminSignupService.signup(request);
    }
}
