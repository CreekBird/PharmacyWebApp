package org.example.pharmacy_web.service;

import io.jsonwebtoken.security.Password;
import org.example.pharmacy_web.controller.dto.LoginRequestDto;
import org.example.pharmacy_web.controller.dto.LoginResponseDto;
import org.example.pharmacy_web.infrastructure.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        var user = userRepository.findByUsername(loginRequestDto.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

        var doPasswordMatch = passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword());

        if(!doPasswordMatch) {
            throw new RuntimeException("Unauthorized");
        }

        return new LoginResponseDto(jwtService.createToken(user));
    }
}

