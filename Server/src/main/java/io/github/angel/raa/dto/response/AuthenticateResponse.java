package io.github.angel.raa.dto.response;


import java.io.Serial;
import java.io.Serializable;

public record AuthenticateResponse(String token) implements Serializable {
    @Serial
    private static final long serialVersionUID = -127832416134267317L;
}
