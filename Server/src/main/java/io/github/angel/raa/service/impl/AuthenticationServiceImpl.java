package io.github.angel.raa.service.impl;

import io.github.angel.raa.configuration.jwt.JwtTokenProvider;
import io.github.angel.raa.dto.request.authentication.Login;
import io.github.angel.raa.dto.request.authentication.Register;
import io.github.angel.raa.dto.response.AuthenticateResponse;
import io.github.angel.raa.dto.response.Response;
import io.github.angel.raa.exception.DuplicateEmailException;
import io.github.angel.raa.exception.DuplicateUsernameException;
import io.github.angel.raa.persistence.entity.Role;
import io.github.angel.raa.persistence.entity.User;
import io.github.angel.raa.persistence.repository.RoleRepository;
import io.github.angel.raa.persistence.repository.UserRepository;
import io.github.angel.raa.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(JwtTokenProvider jwtTokenProvider, BCryptPasswordEncoder passwordEncoder, UserRepository repository, RoleRepository roleRepository, AuthenticationManager authenticationManager) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Response<AuthenticateResponse> login(Login login) {
        String username = login.username();
        String email = login.email();
        String password = login.password();
        if(repository.existsByEmail(email)){
            throw new DuplicateEmailException("El correo electrónico ya está registrado");
        }
        if(repository.existsByUsername(username)){
            throw new DuplicateUsernameException("El nombre de usuario ya está en uso");
        }
        UserDetails details = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Sorry, we couldn't find the user you're looking for. Please double-check the entered information and try again."));

        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);

        authenticationManager.authenticate(authentication);
        String token = jwtTokenProvider.generateToken(details);
        AuthenticateResponse response = new AuthenticateResponse(token);
        return Response.<AuthenticateResponse>builder().message("User logged in successfully")
                .success(true)
                .code(200)
                .data(response)
                .timestamp(LocalDateTime.now())
                .buildResponse();


    }

    @Override
    public Response<AuthenticateResponse> register(Register register) {
        String username = register.username();
        String email = register.email();
        String password = register.password();
        String fullName = register.fullName();
        if(repository.existsByEmail(email)){
            throw new DuplicateEmailException("\"El correo electrónico ya está registrado");
        }
        if(repository.existsByUsername(username)){
            throw new DuplicateUsernameException("El nombre de usuario ya está en uso");
        }
        Role role = new Role();
        User user = new User();
        role.setName(Role.ERole.ROLE_USER);
        roleRepository.save(role);
        user.setUsername(username);
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPassword(passwordEncoder.encode(password));
        user.addRole(role);
        repository.save(user);
        String token = jwtTokenProvider.generateToken(user);
        AuthenticateResponse response = new AuthenticateResponse(token);
        return Response.<AuthenticateResponse>builder().message("User registered successfully")
                .success(true)
                .code(200)
                .data(response)
                .buildResponse();
    }
}
