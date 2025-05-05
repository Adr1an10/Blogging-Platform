package io.github.angel.raa.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = org.springframework.http.HttpStatus.CONFLICT)
public class DuplicateTitleException extends RuntimeException {
    public DuplicateTitleException(String message) {
        super(message);
    }
}
