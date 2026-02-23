package com.sample.entity;

public class CustomerDTO1 {
	
	private Long id;
	
	private String customerDisplayName;
	 private String mobileNumber;
	public CustomerDTO1(Long id, String customerDisplayName, String mobileNumber) {
		
		this.id = id;
		this.customerDisplayName = customerDisplayName;
		this.mobileNumber = mobileNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerDisplayName() {
		return customerDisplayName;
	}
	public void setCustomerDisplayName(String customerDisplayName) {
		this.customerDisplayName = customerDisplayName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	 
	 
}











