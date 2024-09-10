package org.example.bebyundohwi.week1.domain.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.user.dto.request.UserLoginRequest;
import org.example.bebyundohwi.week1.domain.user.dto.request.UserSignupRequest;
import org.example.bebyundohwi.week1.domain.user.facade.UserFacade;
import org.example.bebyundohwi.week1.domain.user.service.UserLoginService;
import org.example.bebyundohwi.week1.domain.user.service.UserReissueService;
import org.example.bebyundohwi.week1.domain.user.service.UserSignupService;
import org.example.bebyundohwi.week1.domain.user.service.AccountIdDuplicateService;
import org.example.bebyundohwi.week1.global.exception.security.jwt.dto.TokenResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Api(tags = {"user에 관련된 회원가입과 ID중복 체크를 제공하는 Controller"})
public class UserController {
    private final UserSignupService userSignupService;
    private final UserLoginService userLoginService;
    private final AccountIdDuplicateService accountIdDuplicateService;
    private final UserReissueService userReissueService;
    private final UserFacade userFacade;

    @PostMapping("/signup")
    @ApiOperation(value = "회원가입")
    public TokenResponse signup(@RequestBody UserSignupRequest userSignupRequest) {
        return userSignupService.userSignUpService(userSignupRequest);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody UserLoginRequest request) {
        return userLoginService.login(request);
    }

    @GetMapping("/duplicate/{accountId}")
    @ApiOperation(value = "ID중복확인")
    public void accountIdDuplicate(@PathVariable String accountId) {
        accountIdDuplicateService.checkAccountIdDuplicate(accountId);
    }

    @PostMapping("/reissue")
    public TokenResponse reissue(@RequestHeader(name = "refresh-token") String token) {
        return userReissueService.reissue(token);
    }

    @GetMapping("/haha")
    public String haha(){
        return "Hello user";
    }

    @GetMapping("sayMyName")
    public String sayName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
