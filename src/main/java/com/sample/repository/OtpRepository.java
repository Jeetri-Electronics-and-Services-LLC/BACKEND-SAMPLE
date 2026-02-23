package com.sample.repository;

import com.sample.entity.Otp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    Otp findByOtpnumberAndUserId(String otpnumber, Long userId);
    
    // Fetch the latest OTP by otpnumber
    Optional<Otp> findTopByOtpnumberOrderByCreatedtimeDesc(String otpnumber);
}
