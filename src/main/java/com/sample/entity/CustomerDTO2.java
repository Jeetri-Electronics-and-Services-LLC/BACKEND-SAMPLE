package com.sample.entity;

public class CustomerDTO2 {
    private Long id;
    private String customerdisplayname;
    private String mobilenumber;
    private String status_id;
    private String createddate;
    private String createdby;
    
    // Prameterized Constructor
	public CustomerDTO2(Long id, String customerdisplayname, String mobilenumber, String status_id, String createddate,
			String createdby) {
		super();
		this.id = id;
		this.customerdisplayname = customerdisplayname;
		this.mobilenumber = mobilenumber;
		this.status_id = status_id;
		this.createddate = createddate;
		this.createdby = createdby;
	}

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerdisplayname() {
		return customerdisplayname;
	}

	public void setCustomerdisplayname(String customerdisplayname) {
		this.customerdisplayname = customerdisplayname;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
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

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
}