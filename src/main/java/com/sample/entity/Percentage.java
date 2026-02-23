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
public class Percentage {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String directdealerpercentage;
    
    private String indirectdealerpercentage;
    
    private String distributorpercentage;
    
    private String marketingreppercentage;
    
    private String representativepercentage;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
    
    // Getters & Setters
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getDirectdealerpercentage() {
		return directdealerpercentage;
	}

	public void setDirectdealerpercentage(String directdealerpercentage) {
		this.directdealerpercentage = directdealerpercentage;
	}

	public String getIndirectdealerpercentage() {
		return indirectdealerpercentage;
	}

	public void setIndirectdealerpercentage(String indirectdealerpercentage) {
		this.indirectdealerpercentage = indirectdealerpercentage;
	}

	public String getDistributorpercentage() {
		return distributorpercentage;
	}

	public void setDistributorpercentage(String distributorpercentage) {
		this.distributorpercentage = distributorpercentage;
	}

	public String getMarketingreppercentage() {
		return marketingreppercentage;
	}

	public void setMarketingreppercentage(String marketingreppercentage) {
		this.marketingreppercentage = marketingreppercentage;
	}

	public String getRepresentativepercentage() {
		return representativepercentage;
	}

	public void setRepresentativepercentage(String representativepercentage) {
		this.representativepercentage = representativepercentage;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
    
    
   

}
