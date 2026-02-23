package com.sample.entity;

public class ExpenseDTOes {
	
	private Long id;
    private String ordertype;
    private String customerdisplayname_id;
    private String amount;
    private String createddate;
    
	
    // Constructor
    public ExpenseDTOes(Long id, String ordertype, String customerdisplayname_id,  String amount, String createddate) {
		
		this.id = id;
		this.ordertype = ordertype;
		this.customerdisplayname_id = customerdisplayname_id;
		this.amount = amount;
		this.createddate = createddate;
	}
    
    // Getters& Setters

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
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
    

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	
    
    
   

}
