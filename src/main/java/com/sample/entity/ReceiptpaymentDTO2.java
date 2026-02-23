package com.sample.entity;

public class ReceiptpaymentDTO2 {
	
	private Long id;
    private String invoiceid;
    private String ordertype;
    private String customerdisplayname_id;
    private String description;
    private String createddate;
    private String createdby;
    private String paymentmethod;
    private String deposital;
    private String amount;
    
    // Getters and Setters
    
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