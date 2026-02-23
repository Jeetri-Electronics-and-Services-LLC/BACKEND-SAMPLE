package com.sample.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Emailestimate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromemail;
    private String toemail;
    private String subject;
    private String emailbody;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estimate_id")
    private Estimate estimate;

 // Constructors
    
	public Emailestimate(Long id, String fromemail, String toemail, String subject, String emailbody, Estimate estimate) {
	
	this.id = id;
	this.fromemail = fromemail;
	this.toemail = toemail;
	this.subject = subject;
	this.emailbody = emailbody;
	this.estimate = estimate;
}

//  getters, and setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromemail() {
		return fromemail;
	}

	public void setFromemail(String fromemail) {
		this.fromemail = fromemail;
	}

	public String getToemail() {
		return toemail;
	}

	public void setToemail(String toemail) {
		this.toemail = toemail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmailbody() {
		return emailbody;
	}

	public void setEmailbody(String emailbody) {
		this.emailbody = emailbody;
	}

	public Estimate getEstimate() {
		return estimate;
	}

	public void setEstimate(Estimate estimate) {
		this.estimate = estimate;
	}
	

	
	
    
	
	

    
	

    
}
