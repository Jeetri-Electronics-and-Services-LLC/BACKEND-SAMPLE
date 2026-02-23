//  Display Invoice details with productdetails(Shipment Tracking)
package com.sample.entity;

import java.util.List;

public class InvoiceResponseDTO {
    private Long invoiceid;
    private String customerdisplayname_id;
    private String invoicedate;
    private String status_id;
    private String total;
    private List<ProductDetailDTO3> productDetails;
    
 // Getters and Setters
	public Long getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(Long invoiceid) {
		this.invoiceid = invoiceid;
	}
	public String getCustomerdisplayname_id() {
		return customerdisplayname_id;
	}
	public void setCustomerdisplayname_id(String customerdisplayname_id) {
		this.customerdisplayname_id = customerdisplayname_id;
	}
	public String getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}
	public String getStatus_id() {
		return status_id;
	}
	public void setStatus_id(String status_id) {
		this.status_id = status_id;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<ProductDetailDTO3> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(List<ProductDetailDTO3> productDetails) {
		this.productDetails = productDetails;
	}
    
 
    
	
    

   
}
