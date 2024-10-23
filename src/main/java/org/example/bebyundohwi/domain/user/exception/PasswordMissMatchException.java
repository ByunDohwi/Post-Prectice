package org.example.bebyundohwi.week1.domain.user.exception;

import org.example.bebyundohwi.week1.global.error.ErrorCode;
import org.example.bebyundohwi.week1.global.exception.CustomException;

public class PasswordMissMatchException extends CustomException {
    public static final CustomException EXCEPTION = new PasswordMissMatchException();
    public PasswordMissMatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
