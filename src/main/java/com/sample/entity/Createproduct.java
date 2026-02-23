package com.sample.entity;
import jakarta.persistence.*;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Createproduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String type_id;
    private String name;
    private String sku;
    private String quantity;
    private String date;
    private String reorder;
    private String description;
    private String msrp;
    private String salesprice;
    private String directdealerprice;   
    private String promotionaldealerprice;  
    private String indirectdealerprice; 
    private String promotionalindirectdelarprice;
    private String distributorprice;
    private String promotionaldistributorprice;
    private String companyprice; 
    private String category_id;
    private String brand_id;
    private String portfolio_id;
    
    @OneToOne(mappedBy = "createproduct", cascade = CascadeType.ALL)
    private Inventoryquantity inventoryquantity;
    
   // Getters and Setters
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
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
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReorder() {
		return reorder;
	}
	public void setReorder(String reorder) {
		this.reorder = reorder;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMsrp() {
		return msrp;
	}
	public void setMsrp(String msrp) {
		this.msrp = msrp;
	}
	public String getSalesprice() {
		return salesprice;
	}
	public void setSalesprice(String salesprice) {
		this.salesprice = salesprice;
	}
	public String getDirectdealerprice() {
		return directdealerprice;
	}
	public void setDirectdealerprice(String directdealerprice) {
		this.directdealerprice = directdealerprice;
	}
	public String getPromotionaldealerprice() {
		return promotionaldealerprice;
	}
	public void setPromotionaldealerprice(String promotionaldealerprice) {
		this.promotionaldealerprice = promotionaldealerprice;
	}
	public String getIndirectdealerprice() {
		return indirectdealerprice;
	}
	public void setIndirectdealerprice(String indirectdealerprice) {
		this.indirectdealerprice = indirectdealerprice;
	}
	public String getCompanyprice() {
		return companyprice;
	}
	public void setCompanyprice(String companyprice) {
		this.companyprice = companyprice;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}
	
	public String getPromotionalindirectdelarprice() {
		return promotionalindirectdelarprice;
	}
	public void setPromotionalindirectdelarprice(String promotionalindirectdelarprice) {
		this.promotionalindirectdelarprice = promotionalindirectdelarprice;
	}
	public String getDistributorprice() {
		return distributorprice;
	}
	public void setDistributorprice(String distributorprice) {
		this.distributorprice = distributorprice;
	}
	public String getPromotionaldistributorprice() {
		return promotionaldistributorprice;
	}
	public void setPromotionaldistributorprice(String promotionaldistributorprice) {
		this.promotionaldistributorprice = promotionaldistributorprice;
	}
	public String getPortfolio_id() {
		return portfolio_id;
	}
	public void setPortfolio_id(String portfolio_id) {
		this.portfolio_id = portfolio_id;
	}
	public Inventoryquantity getInventoryquantity() {
		return inventoryquantity;
	}
	public void setInventoryquantity(Inventoryquantity inventoryquantity) {
		this.inventoryquantity = inventoryquantity;
	}
    
    
    
}
