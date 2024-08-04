package org.example.bebyundohwi.week1.global.error.entity;

import lombok.Builder;
import lombok.Getter;
//import org.example.bebyundohwi.week1.global.error.ErrorCode;
import org.example.bebyundohwi.week1.global.error.ErrorCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponseEntity {

    private int status;
    private String code;
    private String message;
    private LocalDateTime createLocalDateTime;

    public static ResponseEntity<ErrorResponseEntity> responseEntity(ErrorCode errorCode) {
        System.out.println("먀");
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ErrorResponseEntity.builder()
                        .status(errorCode.getHttpStatus())
                        .code(errorCode.name())
                        .message(errorCode.getMessage())
                        .createLocalDateTime(LocalDateTime.now())
                        .build()
                );



    }

}
