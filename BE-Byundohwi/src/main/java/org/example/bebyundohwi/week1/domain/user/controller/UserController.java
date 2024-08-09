package org.example.bebyundohwi.week1.domain.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.user.dto.request.UserRequest;
import org.example.bebyundohwi.week1.domain.user.service.UserSignupService;
import org.example.bebyundohwi.week1.domain.user.service.AccountIdDuplicateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Api(tags = {"user에 관련된 회원가입과 ID중복 체크를 제공하는 Controller"})
public class UserController {
    private final UserSignupService userSignupService;
    private final AccountIdDuplicateService accountIdDuplicateService;

    @PostMapping("/signup")
    @ApiOperation(value = "회원가입")
    public void signup(@RequestBody UserRequest userRequest) {
        userSignupService.userSignUpService(userRequest);
    }

    @GetMapping("/duplicate/{accountId}")
    @ApiOperation(value = "ID중복확인")
    public void accountIdDuplicate(@PathVariable String accountId) {
        accountIdDuplicateService.checkAccountIdDuplicate(accountId);
    }


}
