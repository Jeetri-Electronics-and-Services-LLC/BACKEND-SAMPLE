package com.sample.service;

import com.sample.entity.Otp;
import com.sample.entity.User;
import com.sample.repository.OtpRepository;
import com.sample.repository.UserRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public String generateAndSendOtp(String username, String password) {
        // Fetch user by username and password
        Optional<User> userOpt = userRepository.findByUsernameAndPassword(username, password);

        if (userOpt.isEmpty()) {
            return "Invalid username or password";
        }

        User user = userOpt.get();

        // Generate 6-digit OTP
        String otpNumber = String.valueOf(100000 + new Random().nextInt(900000));

        // Create OTP entity
        Otp otp = new Otp();
        otp.setOtpnumber(otpNumber);
        otp.setCreatedtime(LocalDateTime.now());
        otp.setExpiretime(LocalDateTime.now().plusMinutes(2)); 
        otp.setUser(user);

        // Save OTP to the database
        otpRepository.save(otp);

        // Send OTP to the user's email
        sendOtpEmail(user.getEmail(), otpNumber);

        // Return the generated OTP as part of the response
        return "OTP generated and sent successfully. OTP: " + otpNumber;
    }
    
    public String validateOtp(String otpNumber) {
        // Fetch the OTP from the database by otpNumber
        Optional<Otp> otpOpt = otpRepository.findTopByOtpnumberOrderByCreatedtimeDesc(otpNumber);

        if (otpOpt.isEmpty()) {
            return "Invalid OTP";
        }

        Otp otp = otpOpt.get();

        // Check if the OTP is expired
        if (LocalDateTime.now().isAfter(otp.getExpiretime())) {
            return "OTP has expired";
        }

        return "OTP validated successfully";
    }


    private void sendOtpEmail(String email, String otpNumber) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(email);
            helper.setSubject("Your OTP Code");
            helper.setText("Your OTP is: " + otpNumber + ". It will expire in 2 minutes.");

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
