package com.sample.entity;



import java.util.List;

public class InvoiceDTO1 {
    private Long id;
    private String ordertype;
    private String customerdisplayname_id;
    private String createddate;
    private String billto;
    private String subtotal;
    private String salestax;
    private String total;
    private String notetocustomer;
    private String balanceamount;
    private List<ProductdetailsDTO1> products;
    private List<InvoicewithouttaxDTO1> invoicewithouttax;
    
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
	
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public String getBillto() {
		return billto;
	}
	public void setBillto(String billto) {
		this.billto = billto;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
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
	
	public String getNotetocustomer() {
		return notetocustomer;
	}
	public void setNotetocustomer(String notetocustomer) {
		this.notetocustomer = notetocustomer;
	}
	
	public String getBalanceamount() {
		return balanceamount;
	}
	public void setBalanceamount(String balanceamount) {
		this.balanceamount = balanceamount;
	}
	public List<ProductdetailsDTO1> getProducts() {
		return products;
	}
	public void setProducts(List<ProductdetailsDTO1> products) {
		this.products = products;
	}
	public List<InvoicewithouttaxDTO1> getInvoicewithouttax() {
		return invoicewithouttax;
	}
	public void setInvoicewithouttax(List<InvoicewithouttaxDTO1> invoicewithouttax) {
		this.invoicewithouttax = invoicewithouttax;
	}

    
    
       
		
		 
}
