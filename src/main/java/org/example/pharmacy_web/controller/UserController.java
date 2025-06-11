package org.example.pharmacy_web.controller;

import org.example.pharmacy_web.controller.dto.CreateUserRequestDto;
import org.example.pharmacy_web.controller.dto.CreateUserResponseDto;
import org.example.pharmacy_web.controller.dto.UserResponseDto;
import org.example.pharmacy_web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public CreateUserResponseDto createUser(@RequestBody CreateUserRequestDto user) {
        return userService.createUser(user);
    }
}

