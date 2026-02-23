package com.sample.entity;



public class ReceiptpaymentDTOs {

    private Long id;
    private String invoiceid;
    private String ordertype;
    private String customerdisplayname_id;
    private String description;
    private String createddate;
    private String createdby;
    private String paymentmethod;//dd
    private String deposital;//dd
    private String amount;

    // Constructor
    
  public ReceiptpaymentDTOs(Long id, String invoiceid, String ordertype, String customerdisplayname_id, String description, String createddate,
			String createdby, String paymentmethod, String deposital, String amount) {
		
		this.id = id;
	 	this.invoiceid = invoiceid;
		this.ordertype = ordertype;
		this.customerdisplayname_id = customerdisplayname_id;
		this.description = description;
		this.createddate = createddate;
		this.createdby = createdby;
		this.paymentmethod = paymentmethod;
		this.deposital = deposital;
		this.amount = amount;
	}
  
//Getters and Setters

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getInvoiceid() {
	return invoiceid;
}

public void setInvoiceid(String invoiceid) {
	this.invoiceid = invoiceid;
}

public String getOrdertype() {
	return ordertype;
}

public void setOrdertype(String ordertype) {
	this.ordertype = ordertype;
}



public String getCustomerdisplayname_id() {
	return customerdisplayname_id;
}

public void setCustomerdisplayname_id(String customerdisplayname_id) {
	this.customerdisplayname_id = customerdisplayname_id;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
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

public String getPaymentmethod() {
	return paymentmethod;
}

public void setPaymentmethod(String paymentmethod) {
	this.paymentmethod = paymentmethod;
}

public String getDeposital() {
	return deposital;
}

public void setDeposital(String deposital) {
	this.deposital = deposital;
}

public String getAmount() {
	return amount;
}

public void setAmount(String amount) {
	this.amount = amount;
}


  
}

