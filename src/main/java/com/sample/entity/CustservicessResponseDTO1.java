package com.sample.entity;

import java.util.List;

public class CustservicessResponseDTO1 {
    private Long id;
    private String mobilemonthly;
    private String mobileyearly;
    private String internetoverairmonthly;
    private String internetoverairyearly;
    private String internetoverfiber;
    private String vpn;
    private String standardprices;
    private String servicestartdate;
    private String specialprice;
    private String numberofconnections;
    private List<ConnectiondetailsDTO1> connectiondetails;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMobilemonthly() {
        return mobilemonthly;
    }
    public void setMobilemonthly(String mobilemonthly) {
        this.mobilemonthly = mobilemonthly;
    }
    public String getMobileyearly() {
        return mobileyearly;
    }
    public void setMobileyearly(String mobileyearly) {
        this.mobileyearly = mobileyearly;
    }
    public String getInternetoverairmonthly() {
        return internetoverairmonthly;
    }
    public void setInternetoverairmonthly(String internetoverairmonthly) {
        this.internetoverairmonthly = internetoverairmonthly;
    }
    public String getInternetoverairyearly() {
        return internetoverairyearly;
    }
    public void setInternetoverairyearly(String internetoverairyearly) {
        this.internetoverairyearly = internetoverairyearly;
    }
    public String getInternetoverfiber() {
        return internetoverfiber;
    }
    public void setInternetoverfiber(String internetoverfiber) {
        this.internetoverfiber = internetoverfiber;
    }
    public String getVpn() {
        return vpn;
    }
    public void setVpn(String vpn) {
        this.vpn = vpn;
    }
    public String getStandardprices() {
        return standardprices;
    }
    public void setStandardprices(String standardprices) {
        this.standardprices = standardprices;
    }
    public String getServicestartdate() {
        return servicestartdate;
    }
    public void setServicestartdate(String servicestartdate) {
        this.servicestartdate = servicestartdate;
    }
    public String getSpecialprice() {
        return specialprice;
    }
    public void setSpecialprice(String specialprice) {
        this.specialprice = specialprice;
    }
    public String getNumberofconnections() {
        return numberofconnections;
    }
    public void setNumberofconnections(String numberofconnections) {
        this.numberofconnections = numberofconnections;
    }
	public List<ConnectiondetailsDTO1> getConnectiondetails() {
		return connectiondetails;
	}
	public void setConnectiondetails(List<ConnectiondetailsDTO1> connectiondetails) {
		this.connectiondetails = connectiondetails;
	}
    
}
