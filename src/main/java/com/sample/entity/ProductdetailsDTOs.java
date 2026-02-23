package com.sample.entity;



public class ProductdetailsDTOs {
	private Long id;
	private Long productid;

    private String name;
    private String description;
    private String qty;
    private String salesprice;
    private String amount;
    private String salestaxes_id;
    
    // Getters and Setters
    
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
	public String getSalestaxes_id() {
		return salestaxes_id;
	}
	public void setSalestaxes_id(String salestaxes_id) {
		this.salestaxes_id = salestaxes_id;
	}

   
    
    
}

