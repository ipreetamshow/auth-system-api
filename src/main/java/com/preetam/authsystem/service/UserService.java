package com.preetam.authsystem.service;

import com.preetam.authsystem.dto.LoginRequest;
import com.preetam.authsystem.dto.LoginResponse;
import com.preetam.authsystem.dto.RegisterRequest;
import com.preetam.authsystem.entity.Role;
import com.preetam.authsystem.entity.User;
import com.preetam.authsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public User registerUser(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        return userRepository.save(user);
    }

    // 🔐 JWT LOGIN
    public LoginResponse loginUser(LoginRequest request) {

        // Step 1: Authenticate using Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // Step 2: Generate JWT token
        String token = jwtService.generateToken(request.getEmail());

        // Step 3: Return token
        return new LoginResponse(token);
    }
}