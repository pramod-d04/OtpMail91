Here's a detailed `README.md` file for the project:

```markdown
# OTP Service

This is a Spring Boot application that provides an API for generating and verifying OTPs (One-Time Passwords) and sending custom emails. The OTP format consists of two numbers, followed by two capital letters, and then two more numbers (e.g., `12AB34`).

## Features

- Generate and send OTP via email
- Verify OTP
- Send custom emails with user-specified details

## Technologies Used

- Spring Boot
- Java Mail Sender
- Maven

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.3 or higher

### Setup

1. **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/otp-service.git
    cd otp-service
    ```

2. **Configure Email Settings:**

   Update the `src/main/resources/application.properties` file with your email server settings:
   ```properties
   spring.mail.host=smtp.example.com
   spring.mail.port=587
   spring.mail.username=your-email@example.com
   spring.mail.password=your-email-password
   spring.mail.properties.mail.smtp.auth=true
   spring.mail.properties.mail.smtp.starttls.enable=true
   ```

3. **Build and run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```

## API Endpoints

### Generate OTP

**Endpoint:** `/api/otp/send`

**Method:** `POST`

**Request Body:**
```json
{
  "email": "test@example.com"
}
```

**Response:**
```json
{
  "otp": "12AB34"
}
```

**Example `curl` Command:**
```bash
curl -X POST "http://localhost:8080/api/otp/send" \
-H "Content-Type: application/json" \
-d '{"email":"test@example.com"}'
```

### Verify OTP

**Endpoint:** `/api/otp/verify`

**Method:** `POST`

**Request Body:**
```json
{
  "email": "test@example.com",
  "otp": "12AB34"
}
```

**Response:**
```json
true
```

**Example `curl` Command:**
```bash
curl -X POST "http://localhost:8080/api/otp/verify" \
-H "Content-Type: application/json" \
-d '{"email":"test@example.com", "otp":"12AB34"}'
```

### Send Custom Email

**Endpoint:** `/api/msg/send-custom-email`

**Method:** `POST`

**Request Body:**
```json
{
  "toEmail": "recipient@example.com",
  "name": "John Doe",
  "fromEmail": "sender@example.com",
  "message": "Hello, this is a test message."
}
```

**Example `curl` Command:**
```bash
curl -X POST "http://localhost:8080/api/msg/send-custom-email" \
-H "Content-Type: application/json" \
-d '{
  "toEmail": "recipient@example.com",
  "name": "John Doe",
  "fromEmail": "sender@example.com",
  "message": "Hello, this is a test message."
}'
```

## Project Structure

```
otp-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── otpservice/
│   │   │               ├── OtpServiceApplication.java
│   │   │               ├── controller/
│   │   │               │   └── OtpController.java
│   │   │               ├── model/
│   │   │               │   ├── Otp.java
│   │   │               │   └── CustomEmailRequest.java
│   │   │               └── service/
│   │   │                   └── OtpService.java
│   └── resources/
│       └── application.properties
└── pom.xml
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Java Mail Sender](https://javaee.github.io/javamail/)
```

This `README.md` provides a comprehensive guide to setting up and using the OTP service project, including detailed instructions on configuring the application, API endpoint descriptions, and example `curl` commands for testing the endpoints. Adjust any placeholders (e.g., `yourusername`, email server settings) to match your specific details.
