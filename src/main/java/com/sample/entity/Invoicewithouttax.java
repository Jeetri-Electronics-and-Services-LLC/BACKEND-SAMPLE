package com.sample.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")  
public class Invoicewithouttax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String descriptionwot;
    private String pricewot;
    
    
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescriptionwot() {
		return descriptionwot;
	}


	public void setDescriptionwot(String descriptionwot) {
		this.descriptionwot = descriptionwot;
	}


	public String getPricewot() {
		return pricewot;
	}


	public void setPricewot(String pricewot) {
		this.pricewot = pricewot;
	}


	public Invoice getInvoice() {
		return invoice;
	}


	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	
	
  
}












