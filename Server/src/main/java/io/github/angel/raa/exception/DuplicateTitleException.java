package io.github.angel.raa.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = org.springframework.http.HttpStatus.CONFLICT)
public class DuplicatePostTitleException extends RuntimeException {
    public DuplicatePostTitleException(String message) {
        super(message);
    }
}
