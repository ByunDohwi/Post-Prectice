package org.example.bebyundohwi.week1.domain.user.dto.request;

import lombok.Getter;

@Getter
public class UserSignupRequest {
    private String username;
    private String password;
    private String email;
    private String address;
    private String phone;

}
