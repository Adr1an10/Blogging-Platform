package io.github.angel.raa.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Authentication credentials not found")
public class AuthenticationCredentialsNotFoundException extends RuntimeException {
    public AuthenticationCredentialsNotFoundException(String message) {
        super(message);
    }
}
