package com.sample.entity;

public class CustomerResponseDTO {
    private String customerdisplayname;
    private String emailid;
    private String billto; // Billing details as a single line
    private String shipto; // Shipping details as a single line

    public String getCustomerdisplayname() {
        return customerdisplayname;
    }

    public void setCustomerdisplayname(String customerdisplayname) {
        this.customerdisplayname = customerdisplayname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getBillto() {
        return billto;
    }

    public void setBillto(String billto) {
        this.billto = billto;
    }

    public String getShipto() {
        return shipto;
    }

    public void setShipto(String shipto) {
        this.shipto = shipto;
    }
}
