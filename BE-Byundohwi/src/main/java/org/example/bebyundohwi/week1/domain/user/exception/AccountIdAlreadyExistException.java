package org.example.bebyundohwi.week1.domain.user.exception;

import org.example.bebyundohwi.week1.global.error.ErrorCode;
import org.example.bebyundohwi.week1.global.exception.CustomException;

public class AccountIdAlreadyExistException extends CustomException {

    public static final CustomException EXCEPTION = new AccountIdAlreadyExistException();

    private AccountIdAlreadyExistException() {
        super(ErrorCode.ACCOUNTID_ALREADY_EXISTS);
    }
}
