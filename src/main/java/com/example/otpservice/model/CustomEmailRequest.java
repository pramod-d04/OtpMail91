package com.example.otpservice.model;

public class CustomEmailRequest {
    private String toEmail;
    private String name;
    private String fromEmail;
    private String message;

    public CustomEmailRequest() {}

    public CustomEmailRequest(String toEmail, String name, String fromEmail, String message) {
        this.toEmail = toEmail;
        this.name = name;
        this.fromEmail = fromEmail;
        this.message = message;
    }

    // Getters and Setters
    public String getToEmail() { return toEmail; }
    public void setToEmail(String toEmail) { this.toEmail = toEmail; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFromEmail() { return fromEmail; }
    public void setFromEmail(String fromEmail) { this.fromEmail = fromEmail; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
