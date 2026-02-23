package com.sample.entity;

public class InvoiceCustomerSummaryDTO {

    private Long customerId;
    private String customerDisplayName;
    private Long tenanteInvoiceId;
    private String grandTotal;

    public InvoiceCustomerSummaryDTO() {}

    public InvoiceCustomerSummaryDTO(Long customerId, String customerDisplayName,
                                     Long tenanteInvoiceId, String grandTotal) {
        this.customerId = customerId;
        this.customerDisplayName = customerDisplayName;
        this.tenanteInvoiceId = tenanteInvoiceId;
        this.grandTotal = grandTotal;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerDisplayName() {
        return customerDisplayName;
    }

    public void setCustomerDisplayName(String customerDisplayName) {
        this.customerDisplayName = customerDisplayName;
    }

    public Long getTenanteInvoiceId() {
        return tenanteInvoiceId;
    }

    public void setTenanteInvoiceId(Long tenanteInvoiceId) {
        this.tenanteInvoiceId = tenanteInvoiceId;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
    }
}
