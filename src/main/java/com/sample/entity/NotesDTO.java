package com.sample.entity;



public class NotesDTO {
	
	private Long id;
    private String customerdisplayname_id;
    private String mobilenumber;
    private String createdby;
    private String createddate;
    private String customerstatus;
    private String addnotes;
    
    
    //Constructor
    
    public NotesDTO(Long id, String customerdisplayname_id, String mobilenumber, String createdby, String createddate,
			String customerstatus, String addnotes) {
		
		this.id = id;
		this.customerdisplayname_id = customerdisplayname_id;
		this.mobilenumber = mobilenumber;
		this.createdby = createdby;
		this.createddate = createddate;
		this.customerstatus = customerstatus;
		this.addnotes = addnotes;
	}

	// Getters and Setters
    
    public Long getId() {
		return id;
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

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getCustomerstatus() {
        return customerstatus;
    }

    public void setCustomerstatus(String customerstatus) {
        this.customerstatus = customerstatus;
    }

    public String getAddnotes() {
        return addnotes;
    }

    public void setAddnotes(String addnotes) {
        this.addnotes = addnotes;
    }
    
    @Override
    public String toString() {
        return "NotesDTO{" +
                "id=" + id +
                ", customerdisplayname_id=" + customerdisplayname_id+
                // Add other fields here...
                '}';
    }
	
	public NotesDTO() {
	    // Default constructor
	}

    
    
    
}

    


