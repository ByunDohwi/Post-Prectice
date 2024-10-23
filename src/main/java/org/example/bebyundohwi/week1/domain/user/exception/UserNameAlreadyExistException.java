package org.example.bebyundohwi.week1.domain.user.exception;

import org.example.bebyundohwi.week1.global.error.ErrorCode;
import org.example.bebyundohwi.week1.global.exception.CustomException;

public class UserNameAlreadyExistException extends CustomException {
    public final static CustomException EXCEPTION = new UserNameAlreadyExistException();
    public UserNameAlreadyExistException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}
