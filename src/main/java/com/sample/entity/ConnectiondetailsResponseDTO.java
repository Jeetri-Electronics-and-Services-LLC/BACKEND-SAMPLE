package com.sample.entity;

public class ConnectiondetailsResponseDTO {

	private Long id; 
    private String firstname;
    private String lastname;
    private String imeinumber;
    private String mobilenumber;

    // Getters and Setters
    
    public String getFirstname() {
        return firstname;
    }
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getImeinumber() {
        return imeinumber;
    }
    public void setImeinumber(String imeinumber) {
        this.imeinumber = imeinumber;
    }
    public String getMobilenumber() {
        return mobilenumber;
    }
    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }
}
