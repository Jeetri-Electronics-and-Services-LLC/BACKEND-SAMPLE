package com.sample.entity;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
=======


import com.fasterxml.jackson.annotation.JsonBackReference;
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

<<<<<<< HEAD
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Products {
=======


@Entity
public class Products {

>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    private Long productid;
    private String name;
    private String description;
    private String qty;
    private String salesprice;
    private String amount;
    
    
=======
    private String product;
    private Integer qty;
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125

    @ManyToOne
    @JoinColumn(name = "bundle_id")
    @JsonBackReference
    private Bundle bundle;

<<<<<<< HEAD
=======
    
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
    

   

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

	public Bundle getBundle() {
=======
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Bundle getBundle() {
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
