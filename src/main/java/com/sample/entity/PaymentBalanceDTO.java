package com.sample.entity;

public class PaymentBalanceDTO {
   
    private Long invoiceId;
    private String customerDisplayNameId;
    private String createdDate;
    private String createdBy;
    private String balanceAmount;
    private String receiptPaymentAmount;
    private String totalBalanceAmount;

    // Constructor
    public PaymentBalanceDTO( Long invoiceId, String customerDisplayNameId, String createdDate, 
                             String createdBy, String balanceAmount, String receiptPaymentAmount, 
                             String totalBalanceAmount) {
        
        this.invoiceId = invoiceId;
        this.customerDisplayNameId = customerDisplayNameId;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.balanceAmount = balanceAmount;
        this.receiptPaymentAmount = receiptPaymentAmount;
        this.totalBalanceAmount = totalBalanceAmount;
    }

    // Getters and Setters
    
    public String getCustomerDisplayNameId() { return customerDisplayNameId; }
    public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public void setCustomerDisplayNameId(String customerDisplayNameId) { this.customerDisplayNameId = customerDisplayNameId; }

    public String getCreatedDate() { return createdDate; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public String getBalanceAmount() { return balanceAmount; }
    public void setBalanceAmount(String balanceAmount) { this.balanceAmount = balanceAmount; }

    public String getReceiptPaymentAmount() { return receiptPaymentAmount; }
    public void setReceiptPaymentAmount(String receiptPaymentAmount) { this.receiptPaymentAmount = receiptPaymentAmount; }

    public String getTotalBalanceAmount() { return totalBalanceAmount; }
    public void setTotalBalanceAmount(String totalBalanceAmount) { this.totalBalanceAmount = totalBalanceAmount; }
}
