package io.github.angel.raa.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = org.springframework.http.HttpStatus.CONFLICT)
public class DuplicateSlugException extends RuntimeException {
    public DuplicateSlugException(String message) {
        super(message);
    }
}
