package com.sample.entity;

public class InventoryQuantityDTO1 {
    private Long productid;
    private String productname;
    private String existingquantity;
    private String addedquantity;
    private String totalavailablequantity;
    private String createddate;
    private String createdby;
    
    // Getters & Setters
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
    public String getExistingquantity() {
        return existingquantity;
    }
    public void setExistingquantity(String existingquantity) {
        this.existingquantity = existingquantity;
    }
    public String getAddedquantity() {
        return addedquantity;
    }
    public void setAddedquantity(String addedquantity) {
        this.addedquantity = addedquantity;
    }
    public String getTotalavailablequantity() {
        return totalavailablequantity;
    }
    public void setTotalavailablequantity(String totalavailablequantity) {
        this.totalavailablequantity = totalavailablequantity;
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