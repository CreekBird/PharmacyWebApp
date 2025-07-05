package org.example.pharmacy_web.controller;

import org.example.pharmacy_web.controller.dto.LoginRequestDto;
import org.example.pharmacy_web.controller.dto.LoginResponseDto;
import org.example.pharmacy_web.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @CrossOrigin
    @PostMapping("/login")
    //@PreAuthorize("permitAll()")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        System.out.println("Received login request for: " + loginRequestDto.getUsername());
        return authService.login(loginRequestDto);
    }
    @CrossOrigin
    @PostMapping("/register")
    //@PreAuthorize("permitAll()")
    public LoginResponseDto register(@RequestBody LoginRequestDto registerRequest) {
        return authService.register(registerRequest);
    }
}