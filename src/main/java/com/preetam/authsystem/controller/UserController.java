package com.preetam.authsystem.controller;

import com.preetam.authsystem.dto.LoginRequest;
import com.preetam.authsystem.dto.LoginResponse;
import com.preetam.authsystem.dto.RegisterRequest;
import com.preetam.authsystem.entity.User;
import com.preetam.authsystem.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@Valid @RequestBody RegisterRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return userService.loginUser(request);
    }
}