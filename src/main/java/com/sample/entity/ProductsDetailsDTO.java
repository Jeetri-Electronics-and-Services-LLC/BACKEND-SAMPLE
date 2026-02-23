package com.sample.entity;

public class ProductsDetailsDTO {
	
	private String name;
    private String description;
    private String qty;
    private String salesprice;
    private String amount;

    // Getters and Setters
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

}