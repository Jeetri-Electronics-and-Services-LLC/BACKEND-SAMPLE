package com.sample.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity

public class Paymentbalance {

    @Id
    private Long invoiceid;
    private String customerdisplayname_id;
    private String createddate;
    private String createdby;
    private String balanceamount;
    private String receiptpaymentamount;
    private String totalbalanceamount;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

 // Getters and Setters
	

	public String getCustomerdisplayname_id() {
		return customerdisplayname_id;
	}

	public Long getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(Long invoiceid) {
		this.invoiceid = invoiceid;
	}

	public void setCustomerdisplayname_id(String customerdisplayname_id) {
		this.customerdisplayname_id = customerdisplayname_id;
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

	
	

	public String getBalanceamount() {
		return balanceamount;
	}

	public void setBalanceamount(String balanceamount) {
		this.balanceamount = balanceamount;
	}

	public String getReceiptpaymentamount() {
		return receiptpaymentamount;
	}

	public void setReceiptpaymentamount(String receiptpaymentamount) {
		this.receiptpaymentamount = receiptpaymentamount;
	}

	public String getTotalbalanceamount() {
		return totalbalanceamount;
	}

	public void setTotalbalanceamount(String totalbalanceamount) {
		this.totalbalanceamount = totalbalanceamount;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

    
    
    
    
}
