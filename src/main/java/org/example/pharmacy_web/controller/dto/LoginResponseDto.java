package org.example.pharmacy_web.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponseDto {

    @JsonProperty("token") // Explicit JSON property name
    private String token;

    public LoginResponseDto() {}

    public LoginResponseDto(String token) {
        this.token = token;
    }

    // Standard getter
    public String getToken() {
        return token;
    }

    // Standard setter
    public void setToken(String token) {
        this.token = token;
    }
}