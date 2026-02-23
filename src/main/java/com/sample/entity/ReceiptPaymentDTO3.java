package com.sample.entity;

public class ReceiptPaymentDTO3 {
    private Long id;
    private String invoiceid;
    private String customerdisplayname_id;
    private String createddate;
    private String paymentmethod;//dd
    private String createdby;
    private String amount;
    
    // Default Constructor
	public ReceiptPaymentDTO3() {
	}

// Parameterized Constructor
	public ReceiptPaymentDTO3(Long id, String invoiceid, String customerdisplayname_id, String createddate,
		String paymentmethod, String createdby, String amount) {
	super();
	this.id = id;
	this.invoiceid = invoiceid;
	this.customerdisplayname_id = customerdisplayname_id;
	this.createddate = createddate;
	this.paymentmethod = paymentmethod;
	this.createdby = createdby;
	this.amount = amount;
}

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


	public String getCustomerdisplayname_id() {
		return customerdisplayname_id;
	}


	public void setCustomerdisplayname_id(String customerdisplayname_id) {
		this.customerdisplayname_id = customerdisplayname_id;
	}


	public String getCreateddate() {
		return createddate;
	}


	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}


	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public String getCreatedby() {
		return createdby;
	}


	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}

    
	
   
}
