package io.github.angel.raa.controller;

import io.github.angel.raa.dto.request.authentication.Login;
import io.github.angel.raa.dto.request.authentication.Register;
import io.github.angel.raa.dto.response.AuthenticateResponse;
import io.github.angel.raa.dto.response.Response;
import io.github.angel.raa.exception.WeakPasswordException;
import io.github.angel.raa.service.AuthenticationService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Validated
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationService authenticationService;
    private final CompromisedPasswordChecker compromisedPasswordChecker;
    @GetMapping("/hello")
    @PermitAll()
    public String name (){
        return "Hola Mundo";
    }

    public AuthenticationController(AuthenticationService authenticationService, CompromisedPasswordChecker compromisedPasswordChecker) {
        this.authenticationService = authenticationService;
        this.compromisedPasswordChecker = compromisedPasswordChecker;
    }

    @PostMapping("/register")
    public ResponseEntity<Response<AuthenticateResponse>> register(@Valid @RequestBody Register register){
        CompromisedPasswordDecision decision = compromisedPasswordChecker.check(register.password());
        if (register.password().length() < 8) {
            throw new WeakPasswordException("La contraseña debe tener al menos 8 caracteres.");
        }
        if(decision.isCompromised()){
            log.warn("Intento de registro con contraseña comprometida para usuario: {}", register.username());
            throw new WeakPasswordException("La contraseña ha sido encontrada en una brecha de datos. Por favor, elige una contraseña diferente.");
        }
        // Registro del usuario
        Response<AuthenticateResponse> response = authenticationService.register(register);
        return new ResponseEntity<>(response, response.isSuccess() ? HttpStatus.OK : BAD_REQUEST);
    }
    @PostMapping("/login")
    public ResponseEntity<Response<AuthenticateResponse>> login(@Valid @RequestBody Login login){
        Response<AuthenticateResponse> response = authenticationService.login(login);
        return new ResponseEntity<>(response, response.isSuccess() ? HttpStatus.OK : BAD_REQUEST);
    }
}
