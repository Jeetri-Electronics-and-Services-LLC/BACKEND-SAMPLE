package com.sample.entity;



import java.util.List;

public class EstimateInvoiceResponseDTOes {
    private List<EstimateDTOes> estimates;
    private List<InvoiceDTOes> invoices;
    private List<ExpenseDTOes> expenses;
    private List<ReceiptpaymentDTOes> receiptpayments;
    
    
    
	public EstimateInvoiceResponseDTOes(List<EstimateDTOes> estimates, List<InvoiceDTOes> invoices, List<ExpenseDTOes> expenses,  List<ReceiptpaymentDTOes> receiptpayments) {
		
		this.estimates = estimates;
		this.invoices = invoices;
		this.expenses = expenses;
		this.receiptpayments = receiptpayments;
	    
	}
	public List<EstimateDTOes> getEstimates() {
		return estimates;
	}
	public void setEstimates(List<EstimateDTOes> estimates) {
		this.estimates = estimates;
	}
	public List<InvoiceDTOes> getInvoices() {
		return invoices;
	}
	public void setInvoices(List<InvoiceDTOes> invoices) {
		this.invoices = invoices;
	}
	public List<ExpenseDTOes> getExpenses() {
		return expenses;
	}
	public void setExpenses(List<ExpenseDTOes> expenses) {
		this.expenses = expenses;
	}
	public List<ReceiptpaymentDTOes> getReceiptpayments() {
		return receiptpayments;
	}
	public void setReceiptpayments(List<ReceiptpaymentDTOes> receiptpayments) {
		this.receiptpayments = receiptpayments;
	}
	
	
    
    

    
   
}

