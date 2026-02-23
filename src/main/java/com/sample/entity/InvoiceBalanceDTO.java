package com.sample.entity;



public class InvoiceBalanceDTO {
    private Long id;
    private String customerdisplayname_id;
    private String balanceamount;

    public InvoiceBalanceDTO(Long id, String customerdisplayname_id, String balanceamount) {
        this.id = id;
        this.customerdisplayname_id = customerdisplayname_id;
        this.balanceamount = balanceamount;
    }

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

    public String getBalanceamount() {
        return balanceamount;
    }

    public void setBalanceamount(String balanceamount) {
        this.balanceamount = balanceamount;
    }
}