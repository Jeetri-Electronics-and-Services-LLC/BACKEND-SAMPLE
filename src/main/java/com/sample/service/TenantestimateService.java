package com.sample.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Customer;
import com.sample.entity.Tenantestimate;
import com.sample.entity.TenantestimateFetchRequestDto;
import com.sample.entity.TenantestimateRequestDto;
import com.sample.entity.TenantestimateResponseDto;
import com.sample.repository.CustomerRepository;
import com.sample.repository.TenantestimateRepository;

@Service
public class TenantestimateService {

    @Autowired
    private TenantestimateRepository tenantestimateRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    public Tenantestimate addTenantestimate(TenantestimateRequestDto dto) {

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Tenantestimate tenantestimate = new Tenantestimate();
        tenantestimate.setPluming(dto.getPluming());
        tenantestimate.setFraming(dto.getFraming());
        tenantestimate.setHvac(dto.getHvac());
        tenantestimate.setElectrical(dto.getElectrical());
        tenantestimate.setDropdownceiling(dto.getDropdownceiling());
        tenantestimate.setSheetrockceiling(dto.getSheetrockceiling());
        tenantestimate.setFlooring(dto.getFlooring());
        tenantestimate.setItemdescription(dto.getItemdescription());
        tenantestimate.setSalestax(dto.getSalestax());
        tenantestimate.setCustom(dto.getCustom());
        tenantestimate.setGrandtotal(dto.getGrandtotal());
        tenantestimate.setPrice(dto.getPrice());

        tenantestimate.setCustomer(customer);

        return tenantestimateRepository.save(tenantestimate);
    }
    
    
    public TenantestimateResponseDto fetchTenantestimate(
            TenantestimateFetchRequestDto requestDto) {

        Tenantestimate tenantestimate = tenantestimateRepository
                .findById(requestDto.getTenantestimateId())
                .orElseThrow(() -> new RuntimeException("Tenantestimate not found"));

        TenantestimateResponseDto dto = new TenantestimateResponseDto();
        dto.setId(tenantestimate.getId());
        dto.setPluming(tenantestimate.getPluming());
        dto.setFraming(tenantestimate.getFraming());
        dto.setHvac(tenantestimate.getHvac());
        dto.setElectrical(tenantestimate.getElectrical());
        dto.setDropdownceiling(tenantestimate.getDropdownceiling());
        dto.setSheetrockceiling(tenantestimate.getSheetrockceiling());
        dto.setFlooring(tenantestimate.getFlooring());
        dto.setItemdescription(tenantestimate.getItemdescription());
        dto.setSalestax(tenantestimate.getSalestax());
        dto.setCustom(tenantestimate.getCustom());
        dto.setGrandtotal(tenantestimate.getGrandtotal());
        dto.setPrice(tenantestimate.getPrice());
        dto.setCustomerId(tenantestimate.getCustomer().getId());

        return dto;
    }

}
