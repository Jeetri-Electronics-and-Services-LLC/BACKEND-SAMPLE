package com.sample.entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String otpnumber;

    private LocalDateTime createdtime;

    private LocalDateTime expiretime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public String getOtpnumber() {
		return otpnumber;
	}

	public void setOtpnumber(String otpnumber) {
		this.otpnumber = otpnumber;
	}

	public LocalDateTime getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(LocalDateTime createdtime) {
		this.createdtime = createdtime;
	}

	public LocalDateTime getExpiretime() {
		return expiretime;
	}

	public void setExpiretime(LocalDateTime expiretime) {
		this.expiretime = expiretime;
	}

	public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
