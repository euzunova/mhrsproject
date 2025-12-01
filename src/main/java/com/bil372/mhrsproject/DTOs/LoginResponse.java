package com.bil372.mhrsproject.DTOs;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String role;       // PATIENT / DOCTOR
    private String firstName;
    private String lastName;
}
