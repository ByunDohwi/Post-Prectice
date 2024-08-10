package org.example.bebyundohwi.week1.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {


    USER_ALREADY_EXISTS(409, "Username Already Exists"),
    ACCOUNTED_ALREADY_EXISTS(409, "AccountId Already Exists"),
    USER_NOT_FOUND(404,"존재하지 않는 유저입니다. ");

    private final Integer httpStatus;
    private final String message;
}
