package com.example.otpservice.controller;

import com.example.otpservice.model.CustomEmailRequest;
import com.example.otpservice.model.Otp;
import com.example.otpservice.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> sendCustomEmail(@RequestBody CustomEmailRequest emailRequest) {
        System.out.println("→ sendCustomEmail payload: " + emailRequest);
        otpService.sendCustomEmail(emailRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public String trial(){
        return "Welcome to OTPMAIL91 API";
    }
}
