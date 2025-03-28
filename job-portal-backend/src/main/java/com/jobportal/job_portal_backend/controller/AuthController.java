package com.jobportal.job_portal_backend.controller;

import com.jobportal.job_portal_backend.model.User;
import com.jobportal.job_portal_backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        String token = userService.login(user);
        return token != null ? ResponseEntity.ok(token) : ResponseEntity.status(401).body("Invalid credentials");
    }
}
