package com.sample.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Orderform {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String Customername;
	private String Createddate;
	private String Createdby;
	private String Total;
	
	@OneToMany(mappedBy = "orderform", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orderproduct> orderproducts;
	
	//Getters & Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomername() {
		return Customername;
	}
	public void setCustomername(String customername) {
		Customername = customername;
	}
	public String getCreateddate() {
		return Createddate;
	}
	public void setCreateddate(String createddate) {
		Createddate = createddate;
	}
	public String getCreatedby() {
		return Createdby;
	}
	public void setCreatedby(String createdby) {
		Createdby = createdby;
	}
	public String getTotal() {
		return Total;
	}
	public void setTotal(String total) {
		Total = total;
	}
	public List<Orderproduct> getOrderproducts() {
		return orderproducts;
	}
	public void setOrderproducts(List<Orderproduct> orderproducts) {
		this.orderproducts = orderproducts;
	}
	
	

}
