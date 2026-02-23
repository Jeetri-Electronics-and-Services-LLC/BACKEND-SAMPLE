package com.sample.entity;

public class UserCredentialsDTO {
	private Long id;
    private String username;
    private String password;
    private Long companyId;

    public UserCredentialsDTO(Long id,String username, String password, Long companyId) {
    	this.id = id;
        this.username = username;
        this.password = password;
        this.companyId = companyId;
    }

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPassword(String password) {
        this.password = password;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
