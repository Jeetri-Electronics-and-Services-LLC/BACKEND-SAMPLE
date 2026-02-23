package com.sample.entity;

public class ProductDetailsDTO {
    
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

    // Constructors
    public ProductDetailsDTO(String description, String msrp, String salesprice, String directdealerprice,
                             String promotionaldealerprice, String indirectdealerprice, 
                             String promotionalindirectdelarprice,String distributorprice, String promotionaldistributorprice,String companyprice) {
        this.description = description;
        this.msrp = msrp;
        this.salesprice = salesprice;
        this.directdealerprice = directdealerprice;
        this.promotionaldealerprice = promotionaldealerprice;
        this.indirectdealerprice = indirectdealerprice;
        this.promotionalindirectdelarprice = promotionalindirectdelarprice;
        this.distributorprice = distributorprice;
        this.promotionaldistributorprice = promotionaldistributorprice;
        this.companyprice = companyprice;
    }

 // Getters and Setters
    
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

	public String getCompanyprice() {
		return companyprice;
	}

	public void setCompanyprice(String companyprice) {
		this.companyprice = companyprice;
	}

    
    
}
