package com.sample.entity;

public class InvoiceProductDTO {
    
    private Long productId;
    private String productname;
    private String quantity;

    public InvoiceProductDTO(Long productId, String productname, String quantity) {
        
        this.productId = productId;
        this.productname = productname;
        this.quantity = quantity;
    }

   

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    
    public String getProductname() {
		return productname;
	}



	public void setProductname(String productname) {
		this.productname = productname;
	}



	public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
