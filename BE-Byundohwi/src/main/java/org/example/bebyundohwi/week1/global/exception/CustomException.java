package org.example.bebyundohwi.week1.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.bebyundohwi.week1.global.error.ErrorCode;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private ErrorCode errorCode;

}
