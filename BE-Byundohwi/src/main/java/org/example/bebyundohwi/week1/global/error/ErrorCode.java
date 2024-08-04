package org.example.bebyundohwi.week1.global.error;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {


    USER_NOT_FOUND(404, "User Not Found"),
    ACCOUNTID_ALREADY_EXISTS(409, "AccountId Already Exists"),
    NICKNAME_ALREADY_EXISTS(409, "Nickname Already Exists"),
    STUDENTID_ALREADY_EXISTS(409, "StudentId Already Exists"),
    PASSWORD_MISS_MATCH(400, "Password Miss Match"),

    JWT_EXPIRED(401, "Jwt Expired"),
    JWT_INVALID(401, "Jwt Invalid"),

    IMAGE_UPLOAD_FAILED(400, "Image Upload Failed"),
    IMAGE_VALUE_NOT_FOUND(404, "Image Value Not Found"),

    FEED_NOT_FOUND(404, "Feed Not Found"),
    FEED_WRITER_MISMATCH(403, "Feed Writer Mismatch"),

    TAG_GENERATION_COUNT_EXCEEDED(400, "Tag Generation Count Exceeded"),

    STAR_EXIST(409, "Star Exist"),
    REMOVE_STAR_EXIST(409, "Remove Star Exist");


    private final Integer httpStatus;
    private final String message;
}
