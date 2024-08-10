package org.example.bebyundohwi.week1.domain.user.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserLoginRequest {
    private String username;
    private String password;
}
