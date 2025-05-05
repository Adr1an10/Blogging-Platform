package io.github.angel.raa.service;

import io.github.angel.raa.dto.request.authentication.Login;
import io.github.angel.raa.dto.request.authentication.Register;
import io.github.angel.raa.dto.response.AuthenticateResponse;
import io.github.angel.raa.dto.response.Response;

public interface AuthenticationService {
    Response<AuthenticateResponse> login(Login login);
    Response<AuthenticateResponse> register(Register register);


}
