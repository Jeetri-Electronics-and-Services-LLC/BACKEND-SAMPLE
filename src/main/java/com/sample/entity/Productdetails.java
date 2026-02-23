package com.sample.entity;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")  
public class Productdetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    private Long productid;
    private String name;
    private String description;
    private String qty;
    private String salesprice;
    private String amount;
    private String salestaxes_id;
    
    
    
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    @JsonIgnore // This will prevent the invoice field from being included in JSON output
    private Invoice invoice;
   
    

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

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	
	
	
  
}












