package com.sample.entity;
import jakarta.persistence.*;


import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")  
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    
    private String ordertype;
    private String customerdisplayname_id;
    private String email;
    private String cc;
    private String bcc;
    private String billto;
    private String shipto;
    private String shipvia;
    private String shippingdate;
    private String trackingno;
    private String terms_id;
    private String invoicedate;
    private String duedate;
    private String status_id;
    private String franchiseowner_id;
    private String processedon;
    private String createddate;
    private String city_id;
    private String state_id;
    private String termsandconditions;
    private String subtotal;
    private String discount;
    private String taxablesubtotal;
    private String taxrates_id;
    private String salestax;
    private String total;
    private String deposit;
    private String paycheckto;
    private String balanceamount;
    private String notetocustomer;
    private String internalcustomernotes;
    private String memoonstatement;
    

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Productdetails> products;
    
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoicewithouttax> invoicewithouttax;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Receiptpayment> receiptPayments;
    
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Expense> expenses;
    
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Shipment> shipments;
    
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paymentbalance> paymentBalances;
    


    
    

    
    
//    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<History> history;
    
    // Getters and Setters
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

//	public List<History> getHistory() {
//		return history;
//	}
//
//	public void setHistory(List<History> history) {
//		this.history = history;
//	}

	
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	

	

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getState_id() {
		return state_id;
	}

	public void setState_id(String state_id) {
		this.state_id = state_id;
	}

	public String getCustomerdisplayname_id() {
		return customerdisplayname_id;
	}

	public void setCustomerdisplayname_id(String customerdisplayname_id) {
		this.customerdisplayname_id = customerdisplayname_id;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
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

	public String getShipvia() {
		return shipvia;
	}

	public void setShipvia(String shipvia) {
		this.shipvia = shipvia;
	}

	public String getShippingdate() {
		return shippingdate;
	}

	public void setShippingdate(String shippingdate) {
		this.shippingdate = shippingdate;
	}

	public String getTrackingno() {
		return trackingno;
	}

	public void setTrackingno(String trackingno) {
		this.trackingno = trackingno;
	}

	public String getTerms_id() {
		return terms_id;
	}

	public void setTerms_id(String terms_id) {
		this.terms_id = terms_id;
	}

	public String getInvoicedate() {
		return invoicedate;
	}

	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public String getStatus_id() {
		return status_id;
	}

	public void setStatus_id(String status_id) {
		this.status_id = status_id;
	}

	public String getFranchiseowner_id() {
		return franchiseowner_id;
	}

	public void setFranchiseowner_id(String franchiseowner_id) {
		this.franchiseowner_id = franchiseowner_id;
	}

	public String getTermsandconditions() {
		return termsandconditions;
	}

	public void setTermsandconditions(String termsandconditions) {
		this.termsandconditions = termsandconditions;
	}

	

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getTaxablesubtotal() {
		return taxablesubtotal;
	}

	public void setTaxablesubtotal(String taxablesubtotal) {
		this.taxablesubtotal = taxablesubtotal;
	}

	public String getTaxrates_id() {
		return taxrates_id;
	}

	public void setTaxrates_id(String taxrates_id) {
		this.taxrates_id = taxrates_id;
	}

	public String getSalestax() {
		return salestax;
	}

	public void setSalestax(String salestax) {
		this.salestax = salestax;
	}

	public String getProcessedon() {
		return processedon;
	}

	public void setProcessedon(String processedon) {
		this.processedon = processedon;
	}

	

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getPaycheckto() {
		return paycheckto;
	}

	public void setPaycheckto(String paycheckto) {
		this.paycheckto = paycheckto;
	}

	public String getBalanceamount() {
		return balanceamount;
	}

	public void setBalanceamount(String balanceamount) {
		this.balanceamount = balanceamount;
	}

	public String getNotetocustomer() {
		return notetocustomer;
	}

	public void setNotetocustomer(String notetocustomer) {
		this.notetocustomer = notetocustomer;
	}

	public String getInternalcustomernotes() {
		return internalcustomernotes;
	}

	public void setInternalcustomernotes(String internalcustomernotes) {
		this.internalcustomernotes = internalcustomernotes;
	}

	

	public String getMemoonstatement() {
		return memoonstatement;
	}

	public void setMemoonstatement(String memoonstatement) {
		this.memoonstatement = memoonstatement;
	}

	public List<Productdetails> getProducts() {
		return products;
	}

	public void setProducts(List<Productdetails> products) {
		this.products = products;
	}

	public List<Receiptpayment> getReceiptPayments() {
		return receiptPayments;
	}

	public void setReceiptPayments(List<Receiptpayment> receiptPayments) {
		this.receiptPayments = receiptPayments;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public List<Invoicewithouttax> getInvoicewithouttax() {
		return invoicewithouttax;
	}

	public void setInvoicewithouttax(List<Invoicewithouttax> invoicewithouttax) {
		this.invoicewithouttax = invoicewithouttax;
	}

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	public List<Paymentbalance> getPaymentBalances() {
		return paymentBalances;
	}

	public void setPaymentBalances(List<Paymentbalance> paymentBalances) {
		this.paymentBalances = paymentBalances;
	}

	

	
	
	
	
	

}













