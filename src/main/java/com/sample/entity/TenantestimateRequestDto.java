package com.sample.entity;

public class TenantestimateRequestDto {

    private Long customerId;

    private String pluming;
    private String framing;
    private String hvac;
    private String electrical;
    private String dropdownceiling;
    private String sheetrockceiling;
    private String flooring;
    private String itemdescription;
    private String salestax;
	private String custom;
	private String grandtotal;
    private String price;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPluming() {
        return pluming;
    }

    public void setPluming(String pluming) {
        this.pluming = pluming;
    }

    public String getFraming() {
        return framing;
    }

    public void setFraming(String framing) {
        this.framing = framing;
    }

    public String getHvac() {
        return hvac;
    }

    public void setHvac(String hvac) {
        this.hvac = hvac;
    }

    public String getElectrical() {
        return electrical;
    }

    public void setElectrical(String electrical) {
        this.electrical = electrical;
    }

    public String getDropdownceiling() {
        return dropdownceiling;
    }

    public void setDropdownceiling(String dropdownceiling) {
        this.dropdownceiling = dropdownceiling;
    }

    public String getSheetrockceiling() {
        return sheetrockceiling;
    }

    public void setSheetrockceiling(String sheetrockceiling) {
        this.sheetrockceiling = sheetrockceiling;
    }

    public String getFlooring() {
        return flooring;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

	public String getSalestax() {
		return salestax;
	}

	public void setSalestax(String salestax) {
		this.salestax = salestax;
	}

	public String getCustom() {
		return custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}

	public String getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(String grandtotal) {
		this.grandtotal = grandtotal;
	}
    
}
