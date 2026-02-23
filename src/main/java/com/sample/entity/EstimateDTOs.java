package com.sample.entity;



import java.util.List;

public class EstimateDTOs {

private Long id;
    
    private String ordertype;
    private String customerdisplayname_id;
    private String email;
    private String cc;
    private String bcc;
    private String billto;
    private String shipto;
    private String acceptedby;
    private String estimatedate;
    private String status_id;
    private String franchiseowner_id;
   
    private String createddate;
    private String city_id;
    private String state_id;
    
    private String subtotal;
    private String discount;
    private String taxablesubtotal;
    private String taxrates_id;
    private String salestax;
    private String total;
     private String paycheckto;
   private String notetocustomer;
    private String internalcustomernotes;
    private String memoonstatement;
    private List<EstimateProductDetailsDTOs> estimateProductDetails;
    private List<EstimateWithoutTaxDTOs> estimateWithoutTax;
    
    
    
 // Getters and Setters
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
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
	public String getAcceptedby() {
		return acceptedby;
	}
	public void setAcceptedby(String acceptedby) {
		this.acceptedby = acceptedby;
	}
	public String getEstimatedate() {
		return estimatedate;
	}
	public void setEstimatedate(String estimatedate) {
		this.estimatedate = estimatedate;
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
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getPaycheckto() {
		return paycheckto;
	}
	public void setPaycheckto(String paycheckto) {
		this.paycheckto = paycheckto;
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
	public List<EstimateProductDetailsDTOs> getEstimateProductDetails() {
		return estimateProductDetails;
	}
	public void setEstimateProductDetails(List<EstimateProductDetailsDTOs> estimateProductDetails) {
		this.estimateProductDetails = estimateProductDetails;
	}
	public List<EstimateWithoutTaxDTOs> getEstimateWithoutTax() {
		return estimateWithoutTax;
	}
	public void setEstimateWithoutTax(List<EstimateWithoutTaxDTOs> estimateWithoutTax) {
		this.estimateWithoutTax = estimateWithoutTax;
	}
    
    

    
}
