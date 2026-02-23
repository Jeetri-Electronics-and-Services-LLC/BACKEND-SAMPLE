package com.sample.entity;

import java.util.List;

public class OrderformDTO {
    private String customername;
    private String createddate;
    private String createdby;
    private String total;
    private List<OrderproductDTO> orderproducts;
    
 // Getters & Setters
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
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
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<OrderproductDTO> getOrderproducts() {
		return orderproducts;
	}
	public void setOrderproducts(List<OrderproductDTO> orderproducts) {
		this.orderproducts = orderproducts;
	}

    
    
    
}
