package org.example.bebyundohwi.week1.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {


    USER_ALREADY_EXISTS(404, "User Not Found"),
    ACCOUNTED_ALREADY_EXISTS(409, "AccountId Already Exists");

    private final Integer httpStatus;
    private final String message;
}
