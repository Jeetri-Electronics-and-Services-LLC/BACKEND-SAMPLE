package com.sample.entity;

public class CustomerNameResponseDTO {

    private Long id;
    private String customerName;

    public CustomerNameResponseDTO(Long id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }
}
