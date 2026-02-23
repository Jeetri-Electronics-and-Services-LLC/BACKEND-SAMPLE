package com.sample.entity;

import java.util.List;

public class InvoiceDTO3 {
    private Long id;
    private String ordertype;
    private String customerdisplayname_id;
    private String status_id;
    private String createddate;
    private String franchiseowner_id;
    private String balanceamount;
    
    
    // Constructor
	
	public InvoiceDTO3(Long id, String ordertype, String customerdisplayname_id, String status_id, String createddate,
			String franchiseowner_id, String balanceamount) {
		
		this.id = id;
		this.ordertype = ordertype;
		this.customerdisplayname_id = customerdisplayname_id;
		this.status_id = status_id;
		this.createddate = createddate;
		this.franchiseowner_id = franchiseowner_id;
		this.balanceamount = balanceamount;
	}

	// Getters & Setters
		public Long getId() {
			return id;
		}
	public void setId(Long id) {
		this.id = id;
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


	public String getFranchiseowner_id() {
		return franchiseowner_id;
	}


	public void setFranchiseowner_id(String franchiseowner_id) {
		this.franchiseowner_id = franchiseowner_id;
	}


	public String getBalanceamount() {
		return balanceamount;
	}


	public void setBalanceamount(String balanceamount) {
		this.balanceamount = balanceamount;
	}

	
    
}
