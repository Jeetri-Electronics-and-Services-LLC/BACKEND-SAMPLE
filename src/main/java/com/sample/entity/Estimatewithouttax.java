package com.sample.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Estimatewithouttax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descriptionwot;
    private String pricewot;
    

    @ManyToOne
    @JoinColumn(name = "estimate_id")
    private Estimate estimate;

 // Getters and Setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescriptionwot() {
		return descriptionwot;
	}


	public void setDescriptionwot(String descriptionwot) {
		this.descriptionwot = descriptionwot;
	}


	public String getPricewot() {
		return pricewot;
	}


	public void setPricewot(String pricewot) {
		this.pricewot = pricewot;
	}


	public Estimate getEstimate() {
		return estimate;
	}


	public void setEstimate(Estimate estimate) {
		this.estimate = estimate;
	}

    
    
    

    
}
