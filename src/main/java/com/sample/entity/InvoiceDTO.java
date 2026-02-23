package com.sample.entity;


//InvoiceDTO.java
public class InvoiceDTO {
private Long id;
    
    private String ordertype;
    private String customerdisplayname_id;
    
    
    private String status_id;
    private String createddate;
    
    private String total;
    private String deposit;
    private String balanceamount;
    private String memoonstatement;
    
 // Getters and Setters
    
    
    
	public Long getId() {
		return id;
	}
	public InvoiceDTO(Long id, String ordertype, String customerdisplayname_id, 
		String status_id, String createddate,  String total, String deposit, String balanceamount,
		String memoonstatement) {
	
	this.id = id;
	this.ordertype = ordertype;
	this.customerdisplayname_id = customerdisplayname_id;
	
	this.status_id = status_id;
	this.createddate = createddate;
	
	this.total = total;
	this.deposit = deposit;
	this.balanceamount = balanceamount;
	this.memoonstatement = memoonstatement;
}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCustomerdisplayname_id() {
		return customerdisplayname_id;
	}
	public void setCustomerdisplayname_id(String customerdisplayname_id) {
		this.customerdisplayname_id = customerdisplayname_id;
	}
	
	
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	public String getStatus_id() {
		return status_id;
	}
	public void setStatus_id(String status_id) {
		this.status_id = status_id;
	}
	
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getBalanceamount() {
		return balanceamount;
	}
	public void setBalanceamount(String balanceamount) {
		this.balanceamount = balanceamount;
	}
	public String getMemoonstatement() {
		return memoonstatement;
	}
	public void setMemoonstatement(String memoonstatement) {
		this.memoonstatement = memoonstatement;
	}
	
    
    

 
}
