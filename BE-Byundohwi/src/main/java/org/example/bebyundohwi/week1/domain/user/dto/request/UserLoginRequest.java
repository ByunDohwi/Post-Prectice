package org.example.bebyundohwi.week1.domain.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserLoginRequest {
    private String username;
    private String password;

    public UserLoginRequest(UserSignupRequest request) {
        this.username = request.getUsername();
        this.password = request.getPassword();
    }
}
