package com.example.otpservice.controller;

import com.example.otpservice.model.CustomEmailRequest;
import com.example.otpservice.model.Otp;
import com.example.otpservice.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/otp/send")
    public String sendOtp(@RequestBody Otp otpRequest) {
        return otpService.generateOtp(otpRequest.getEmail());
    }

    @PostMapping("/otp/verify")
    public boolean verifyOtp(@RequestBody Otp otpRequest) {
        return otpService.verifyOtp(otpRequest);
    }

    @PostMapping("/msg/send-custom-email")
    public void sendCustomEmail(@RequestBody CustomEmailRequest emailRequest) {
        otpService.sendCustomEmail(emailRequest);
    }

    @GetMapping("/")
    public String trial(){
        return "Welcome to OTPMAIL91 API";
    }
}
