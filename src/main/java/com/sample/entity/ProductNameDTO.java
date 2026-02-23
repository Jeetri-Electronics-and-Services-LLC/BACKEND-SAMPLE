package com.sample.entity;

public class ProductNameDTO {
	private Long id;
    private String name;

    

    public ProductNameDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// Getter and Setter
    
    
    public String getName() {
        return name;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
        this.name = name;
    }
}
