package org.example.bebyundohwi.week1.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.user.dto.request.UserRequest;
import org.example.bebyundohwi.week1.domain.user.repository.UserRepository;
import org.example.bebyundohwi.week1.domain.user.service.AccountIdDuplicateService;
import org.example.bebyundohwi.week1.domain.user.service.UserSignupService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserSignupService userSignupService;
    private final AccountIdDuplicateService accountIdDuplicateService;

    @PostMapping("signup")
    public void signup(@RequestBody UserRequest userRequest) {
        userSignupService.userSignUpService(userRequest);
    }

    @GetMapping("/duplicate/{accountId}")
    public void accountIdDuplicate(@PathVariable String accountId) {
        accountIdDuplicateService.checkAccountIdDuplicate(accountId);
    }


}
