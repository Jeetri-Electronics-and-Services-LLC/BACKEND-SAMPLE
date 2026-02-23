package com.sample.entity;

public class InvoicewithouttaxDTO {

   private Long id;
    private String descriptionwot;
    private String pricewot;
    
    
    
	public InvoicewithouttaxDTO(Long id, String descriptionwot, String pricewot) {
		
		this.id = id;
		this.descriptionwot = descriptionwot;
		this.pricewot = pricewot;
	}
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

}












