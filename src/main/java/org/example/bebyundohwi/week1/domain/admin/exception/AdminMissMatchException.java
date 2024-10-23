package org.example.bebyundohwi.week1.domain.admin.exception;

import org.example.bebyundohwi.week1.global.error.ErrorCode;
import org.example.bebyundohwi.week1.global.exception.CustomException;

public class AdminMissMatchException extends CustomException {
    public final static CustomException EXCEPTION = new AdminMissMatchException();

    public AdminMissMatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
