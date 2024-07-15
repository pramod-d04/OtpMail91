package com.example.otpservice.service;

import com.example.otpservice.model.CustomEmailRequest;
import com.example.otpservice.model.Otp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OtpService {

    @Autowired
    private JavaMailSender mailSender;

    private Map<String, String> otpStore = new HashMap<>();

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random RANDOM = new Random();

    public String generateOtp(String email) {
        String otp = generateRandomOtp();
        otpStore.put(email, otp);
        sendOtpEmail(email, otp);
        return "OTP Sent successfully";
    }

    private String generateRandomOtp() {
        StringBuilder otp = new StringBuilder(6);
        otp.append(RANDOM.nextInt(10));
        otp.append(RANDOM.nextInt(10));
        otp.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()))); 
        otp.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()))); 
        otp.append(RANDOM.nextInt(10)); 
        otp.append(RANDOM.nextInt(10)); 
        return otp.toString();
    }

    private void sendOtpEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + otp);
        mailSender.send(message);
    }

    public boolean verifyOtp(Otp otpRequest) {
        return otpStore.get(otpRequest.getEmail()) != null && otpStore.get(otpRequest.getEmail()).equals(otpRequest.getOtp());
    }

    public void sendCustomEmail(CustomEmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getToEmail());
        message.setFrom(emailRequest.getFromEmail());
        message.setSubject("Message from " + emailRequest.getName());
        message.setText(emailRequest.getMessage());
        mailSender.send(message);
    }
}
