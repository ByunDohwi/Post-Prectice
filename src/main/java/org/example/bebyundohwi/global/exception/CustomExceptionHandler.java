package org.example.bebyundohwi.week1.global.exception;

import org.example.bebyundohwi.week1.global.error.entity.ErrorResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponseEntity> handleCustomException(CustomException customException) {
        return ErrorResponseEntity.responseEntity(customException.getErrorCode());
    }
}
