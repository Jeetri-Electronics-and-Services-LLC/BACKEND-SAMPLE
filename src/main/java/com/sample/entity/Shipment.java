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
public class Shipment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
	private String invoiceid;
	private String productid;
	private String productname;
	private String quantity;
	private String shipmentquantity;
	private String shipmentdate;
	private String userid;
	
	
	 @ManyToOne
	    @JoinColumn(name = "invoice_id") 
	    private Invoice invoice;
	 
	 @ManyToOne
	    @JoinColumn(name = "user_id") 
	    private User user;
	
	// Getters & Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getShipmentquantity() {
		return shipmentquantity;
	}
	public void setShipmentquantity(String shipmentquantity) {
		this.shipmentquantity = shipmentquantity;
	}
	public String getShipmentdate() {
		return shipmentdate;
	}
	public void setShipmentdate(String shipmentdate) {
		this.shipmentdate = shipmentdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
