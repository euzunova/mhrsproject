package com.bil372.mhrsproject.DTOs;

import lombok.Data;

@Data
public class LoginRequest {

    // PATIENT / DOCTOR için
    private Long nationalId;

    // ADMIN için
    private String username;

    // hepsi için ortak
    private String password;

    // "PATIENT", "DOCTOR", "ADMIN"
    private String userType;
}
