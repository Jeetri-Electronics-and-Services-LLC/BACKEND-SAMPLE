package com.sample.entity;

public class ProductDTO {

    private String productid;
    private String productname;
    private String totalavailablequantity;

    // Constructor
    public ProductDTO(String productid, String productname, String totalavailablequantity) {
        this.productid = productid;
        this.productname = productname;
        this.totalavailablequantity = totalavailablequantity;
    }

    // Getters and Setters
    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getTotalavailablequantity() {
        return totalavailablequantity;
    }

    public void setTotalavailablequantity(String totalavailablequantity) {
        this.totalavailablequantity = totalavailablequantity;
    }
}
