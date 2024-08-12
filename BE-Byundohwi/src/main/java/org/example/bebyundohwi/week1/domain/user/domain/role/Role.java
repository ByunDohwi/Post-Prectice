package org.example.bebyundohwi.week1.domain.user.domain.role;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN("admin"),
    USER("user");

    private final String role;


}
