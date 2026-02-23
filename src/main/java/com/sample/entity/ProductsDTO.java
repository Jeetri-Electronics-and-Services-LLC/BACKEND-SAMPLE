package com.sample.entity;

public class ProductsDTO {
	
    private Long id;
    private String description;
    private String salesprice;

    

    

	public ProductsDTO(Long id, String description, String salesprice) {
		super();
		this.id = id;
		this.description = description;
		this.salesprice = salesprice;
	}

	// Getters and Setters
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalesprice() {
        return salesprice;
    }

    public void setSalesprice(String salesprice) {
        this.salesprice = salesprice;
    }
}
