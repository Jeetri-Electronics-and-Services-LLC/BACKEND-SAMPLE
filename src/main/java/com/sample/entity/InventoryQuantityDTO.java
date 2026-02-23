package com.sample.entity;

public class InventoryQuantityDTO {

    private Long productid;
    private String productname;
    private String addedquantity;
    private String createddate;
    private String createdby;

    // Constructor
    public InventoryQuantityDTO(Long productid, String productname, String addedquantity, String createddate, String createdby) {
        this.productid = productid;
        this.productname = productname;
        this.addedquantity = addedquantity;
        this.createddate = createddate;
        this.createdby = createdby;
    }

    // Getters and Setters
    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getAddedquantity() {
        return addedquantity;
    }

    public void setAddedquantity(String addedquantity) {
        this.addedquantity = addedquantity;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }
}
