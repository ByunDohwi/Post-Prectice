package org.example.bebyundohwi.week1.global.exception.security.exception;

import org.example.bebyundohwi.week1.global.error.ErrorCode;
import org.example.bebyundohwi.week1.global.exception.CustomException;

public class InvalidTokenException extends CustomException {
    public static final CustomException EXCEPTION = new InvalidTokenException();
    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
