package com.example.otpservice.model;

public class Otp {
    private String email;
    private String otp;

    public Otp(String email, String otp) {
        this.email = email;
        this.otp = otp;
    }

    // Getters
    public String getEmail() { return email; }
    public String getOtp() { return otp; }
}
