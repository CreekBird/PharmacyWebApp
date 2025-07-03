package org.example.pharmacy_web.service;

import org.example.pharmacy_web.controller.dto.CreateUserRequestDto;
import org.example.pharmacy_web.controller.dto.CreateUserResponseDto;
import org.example.pharmacy_web.controller.dto.UserResponseDto;
import org.example.pharmacy_web.infrastructure.entity.UserEntity;
import org.example.pharmacy_web.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public CreateUserResponseDto createUser(CreateUserRequestDto userDto) {
        var userEntity = new UserEntity();

        var hashedPassword = passwordEncoder.encode(userDto.getPassword());

        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(hashedPassword);
        var savedUser = userRepository.save(userEntity);

        return new CreateUserResponseDto(savedUser.getId());
    }

    public UserResponseDto getUser(long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponseDto(user.getId(), user.getUsername());
    }
}