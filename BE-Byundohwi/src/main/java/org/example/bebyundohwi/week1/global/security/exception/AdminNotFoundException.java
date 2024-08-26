package org.example.bebyundohwi.week1.global.security.exception;

import org.example.bebyundohwi.week1.global.error.ErrorCode;
import org.example.bebyundohwi.week1.global.exception.CustomException;

public class AdminNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new AdminNotFoundException();
    public AdminNotFoundException() {
        super(ErrorCode.ADMIN_NOT_FOUND);
    }
}
