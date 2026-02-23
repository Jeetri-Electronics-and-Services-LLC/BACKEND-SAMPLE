package com.sample.controller;

import com.sample.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/generateotp")
    public ResponseEntity<String> generateOtp(@RequestBody UserCredentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        // Generate OTP and send to email
        String response = otpService.generateAndSendOtp(username, password);

        return ResponseEntity.ok(response);
    }

    // DTO class to represent the input data
    public static class UserCredentials {
        private String username;
        private String password;

        // Getters and Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
    
    @PostMapping("/validateotp")
    public ResponseEntity<String> validateOtp(@RequestBody OtpValidationRequest request) {
        String response = otpService.validateOtp(request.getOtp());
        return ResponseEntity.ok(response);
    }

    // DTO class for validating OTP
    public static class OtpValidationRequest {
        private String otp;

        // Getters and Setters
        public String getOtp() {
            return otp;
        }

        public void setOtp(String otp) {
            this.otp = otp;
        }
    }

}
