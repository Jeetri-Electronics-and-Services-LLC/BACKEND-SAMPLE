package com.sample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orderproduct {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private Long productid;
    private String name;
    private String description;
    private String qty;
    private String salesprice;
    private String amount;
    
    @ManyToOne
    @JoinColumn(name = "orderform_id")
    private Orderform orderform;
    
    //Getters & Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductid() {
		return productid;
	}
	public void setProductid(Long productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getSalesprice() {
		return salesprice;
	}
	public void setSalesprice(String salesprice) {
		this.salesprice = salesprice;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Orderform getOrderform() {
		return orderform;
	}
	public void setOrderform(Orderform orderform) {
		this.orderform = orderform;
	}
    
    

}
