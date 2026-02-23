package com.sample.entity;

public class Customersummary {

    private Long id;
    
    private String customerdisplayname;
    
    private String mobilenumber;
    
    // Constructor
    public Customersummary(Long id,  
                           String customerdisplayname,  String mobilenumber) {
       this.id = id;
        
        this.customerdisplayname = customerdisplayname;
        
        this.mobilenumber = mobilenumber;
        
    }

    // Getters and Setters
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

	
    
    
}
