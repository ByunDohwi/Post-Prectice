package org.example.bebyundohwi.week1.domain.post.exception;

import org.example.bebyundohwi.week1.global.error.ErrorCode;
import org.example.bebyundohwi.week1.global.exception.CustomException;

public class PostNotFoundException extends CustomException {
    public final static CustomException EXCEPTION = new PostNotFoundException();

    public PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
