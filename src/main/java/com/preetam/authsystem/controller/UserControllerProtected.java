package com.preetam.authsystem.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserControllerProtected {

    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public String userProfile() {
        return "Welcome User!";
    }
}