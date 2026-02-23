//package com.sample.entity;
//
//
//
//public class RecentCustomerNoteDTO {
//    private String customerId;
//    private String createdDate;
//    private String customerStatus;
//
//    // Constructors
//    public RecentCustomerNoteDTO(String customerId, String createdDate, String customerStatus) {
//        this.customerId = customerId;
//        this.createdDate = createdDate;
//        this.customerStatus = customerStatus;
//    }
//
//    // Getters and Setters
//    public String getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(String customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(String createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public String getCustomerStatus() {
//        return customerStatus;
//    }
//
//    public void setCustomerStatus(String customerStatus) {
//        this.customerStatus = customerStatus;
//    }
//}




package com.sample.entity;

public class RecentCustomerNoteDTO {
    private Long customerId;
    private String createdDate;
    private String customerStatus;

    // Constructors
    public RecentCustomerNoteDTO(Long customerId, String createdDate, String customerStatus) {
        this.customerId = customerId;
        this.createdDate = createdDate;
        this.customerStatus = customerStatus;
    }

    // Getters and Setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }
}



