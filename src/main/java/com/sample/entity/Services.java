package com.sample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Services {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name;
	String sku;
	String description;
	double salesprice;
	double salestax;
	
	private String category_id;
	private String income_account_id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSku() {
		return sku;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getSalesprice() {
		return salesprice;
	}
	
	public void setSalesprice(double salesprice) {
		this.salesprice = salesprice;
	}
	
	public double getSalestax() {
		return salestax;
	}
	
	public void setSalestax(double salestax) {
		this.salestax = salestax;
	}
	
	public String getCategory_id() {
		return category_id;
	}
	
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	
	public String getIncome_account_id() {
		return income_account_id;
	}
	
	public void setIncome_account_id(String income_account_id) {
		this.income_account_id = income_account_id;
	}

}
