package com.sample.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String firstname;
    private String middlename;
    private String lastname;
    private String suffix;
    private String companyname;
    private String customerdisplayname;
    private String emailid;
    private String phonenumber;
    private String mobilenumber;
    private String fax;
    private String other;
    private String website;
    private String nametoprintonchecks;
    private String billingstreetaddress;
    private String billingplatnumber ;
    private String billingcity_id;
    private String billingstate_id;
    private String billingcountry_id;
    private String billingzipcode;
    private String shipingstreetaddress;
    private String shipingplatnumber ;
    private String shipingcity_id;
    private String shipingstate_id;
    private String shipingcountry_id;
    private String shipingzipcode;
    private String note;
    private String primarypaymentmethod_id;
    private String terms_id;
    private String salesfromdeliveryoptions_id;
    private String languages_id;
    private String customertype_id;
   
    private String status_id;
    private String franchiseowner_id;
    private String createddate;
    private String createdby;
    private String followedby;
    
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estimate> estimates;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Expense> expenses;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Receiptpayment> receiptpayments;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notes> notes;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paymentbalance> paymentbalances;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tenantestimate> Tenantestimates;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tenanteinvoice> Tenanteinvoices;
 
    

    // Getters and Setters
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getNametoprintonchecks() {
		return nametoprintonchecks;
	}

	public void setNametoprintonchecks(String nametoprintonchecks) {
		this.nametoprintonchecks = nametoprintonchecks;
	}

	

	

	public String getBillingstreetaddress() {
		return billingstreetaddress;
	}

	public void setBillingstreetaddress(String billingstreetaddress) {
		this.billingstreetaddress = billingstreetaddress;
	}

	public String getBillingplatnumber() {
		return billingplatnumber;
	}

	public void setBillingplatnumber(String billingplatnumber) {
		this.billingplatnumber = billingplatnumber;
	}

	public String getBillingcity_id() {
		return billingcity_id;
	}

	public void setBillingcity_id(String billingcity_id) {
		this.billingcity_id = billingcity_id;
	}

	public String getBillingstate_id() {
		return billingstate_id;
	}

	public void setBillingstate_id(String billingstate_id) {
		this.billingstate_id = billingstate_id;
	}

	public String getBillingcountry_id() {
		return billingcountry_id;
	}

	public void setBillingcountry_id(String billingcountry_id) {
		this.billingcountry_id = billingcountry_id;
	}

	public String getBillingzipcode() {
		return billingzipcode;
	}

	public void setBillingzipcode(String billingzipcode) {
		this.billingzipcode = billingzipcode;
	}

	public String getShipingstreetaddress() {
		return shipingstreetaddress;
	}

	public void setShipingstreetaddress(String shipingstreetaddress) {
		this.shipingstreetaddress = shipingstreetaddress;
	}

	public String getShipingplatnumber() {
		return shipingplatnumber;
	}

	public void setShipingplatnumber(String shipingplatnumber) {
		this.shipingplatnumber = shipingplatnumber;
	}

	public String getShipingcity_id() {
		return shipingcity_id;
	}

	public void setShipingcity_id(String shipingcity_id) {
		this.shipingcity_id = shipingcity_id;
	}

	public String getShipingstate_id() {
		return shipingstate_id;
	}

	public void setShipingstate_id(String shipingstate_id) {
		this.shipingstate_id = shipingstate_id;
	}

	public String getShipingcountry_id() {
		return shipingcountry_id;
	}

	public void setShipingcountry_id(String shipingcountry_id) {
		this.shipingcountry_id = shipingcountry_id;
	}

	public String getShipingzipcode() {
		return shipingzipcode;
	}

	public void setShipingzipcode(String shipingzipcode) {
		this.shipingzipcode = shipingzipcode;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPrimarypaymentmethod_id() {
		return primarypaymentmethod_id;
	}

	public void setPrimarypaymentmethod_id(String primarypaymentmethod_id) {
		this.primarypaymentmethod_id = primarypaymentmethod_id;
	}

	public String getTerms_id() {
		return terms_id;
	}

	public void setTerms_id(String terms_id) {
		this.terms_id = terms_id;
	}

	public String getSalesfromdeliveryoptions_id() {
		return salesfromdeliveryoptions_id;
	}

	public void setSalesfromdeliveryoptions_id(String salesfromdeliveryoptions_id) {
		this.salesfromdeliveryoptions_id = salesfromdeliveryoptions_id;
	}

	public String getLanguages_id() {
		return languages_id;
	}

	public void setLanguages_id(String languages_id) {
		this.languages_id = languages_id;
	}

	

	public String getCustomertype_id() {
		return customertype_id;
	}

	public void setCustomertype_id(String customertype_id) {
		this.customertype_id = customertype_id;
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

	public String getFollowedby() {
		return followedby;
	}

	public void setFollowedby(String followedby) {
		this.followedby = followedby;
	}

	

	public List<Estimate> getEstimates() {
		return estimates;
	}

	public void setEstimates(List<Estimate> estimates) {
		this.estimates = estimates;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public List<Receiptpayment> getReceiptpayments() {
		return receiptpayments;
	}

	public void setReceiptpayments(List<Receiptpayment> receiptpayments) {
		this.receiptpayments = receiptpayments;
	}

	public List<Notes> getNotes() {
		return notes;
	}

	public void setNotes(List<Notes> notes) {
		this.notes = notes;
	}

	public List<Paymentbalance> getPaymentbalances() {
		return paymentbalances;
	}

	public void setPaymentbalances(List<Paymentbalance> paymentbalances) {
		this.paymentbalances = paymentbalances;
	}

	public List<Tenantestimate> getTenantestimates() {
		return Tenantestimates;
	}

	public void setTenantestimates(List<Tenantestimate> tenantestimates) {
		Tenantestimates = tenantestimates;
	}

	public List<Tenanteinvoice> getTenanteinvoices() {
		return Tenanteinvoices;
	}

	public void setTenanteinvoices(List<Tenanteinvoice> tenanteinvoices) {
		Tenanteinvoices = tenanteinvoices;
	}
	
	
	
}


