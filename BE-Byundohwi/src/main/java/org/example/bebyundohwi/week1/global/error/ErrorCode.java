package org.example.bebyundohwi.week1.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_ALREADY_EXISTS(409, "Username Already Exists"),
    USER_NOT_FOUND(404,"존재하지 않는 유저입니다. "),
    PASSWORD_MISMATCH(401,"Password MisMatch"),
    ACCOUNTED_ALREADY_EXISTS(409, "AccountId Already Exists"),
    ADMIN_NOT_FOUND(404,"존재하지 않는 관리자입니다."),
    ADMIN_MISMATCH(401,""),

    POST_NOT_FOUND(404,"존재하지 않는 게시물입니다."),

    INVALID_TOKEN(401,"Invalid Token."),
    EXPIRED_TOKEN(401, "Expired Token"),
    INTERNAL_SERVER_ERROR(500,"Internal Server Error");

    private Integer httpStatus;
    private String message;
}
