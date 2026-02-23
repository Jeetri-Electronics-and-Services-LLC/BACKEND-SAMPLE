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
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerdisplayname_id;
    private String mobilenumber;
    private String createdby;
    private String createddate;
    private String customerstatus;  //dd
    private String addnotes;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Getters and Setters
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerdisplayname_id() {
		return customerdisplayname_id;
	}

	public void setCustomerdisplayname_id(String customerdisplayname_id) {
		this.customerdisplayname_id = customerdisplayname_id;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getCustomerstatus() {
		return customerstatus;
	}

	public void setCustomerstatus(String customerstatus) {
		this.customerstatus = customerstatus;
	}

	public String getAddnotes() {
		return addnotes;
	}

	public void setAddnotes(String addnotes) {
		this.addnotes = addnotes;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


   
   
    
}
