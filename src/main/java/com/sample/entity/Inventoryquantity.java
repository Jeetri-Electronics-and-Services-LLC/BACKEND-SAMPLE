package com.sample.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Inventoryquantity {

    @Id
    private Long productid;
    private String productname;
    private String existingquantity;
    private String addedquantity;
    private String totalavailablequantity;
    private String createddate;
    private String createdby;
    
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Createproduct createproduct;
    
 // Getters & Setters
	public Long getProductid() {
		return productid;
	}
	public void setProductid(Long productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getExistingquantity() {
		return existingquantity;
	}
	public void setExistingquantity(String existingquantity) {
		this.existingquantity = existingquantity;
	}
	public String getAddedquantity() {
		return addedquantity;
	}
	public void setAddedquantity(String addedquantity) {
		this.addedquantity = addedquantity;
	}
	public String getTotalavailablequantity() {
		return totalavailablequantity;
	}
	public void setTotalavailablequantity(String totalavailablequantity) {
		this.totalavailablequantity = totalavailablequantity;
	}
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Createproduct getCreateproduct() {
		return createproduct;
	}
	public void setCreateproduct(Createproduct createproduct) {
		this.createproduct = createproduct;
	}

    
    
}
