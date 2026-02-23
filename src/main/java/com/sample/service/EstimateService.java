package com.sample.service;

import com.sample.entity.Customer;


import com.sample.entity.Estimate;
import com.sample.entity.EstimateDTO;
import com.sample.entity.EstimateDTO1;
import com.sample.entity.EstimateDTO2;
import com.sample.entity.EstimateProductDetailResponseDTO;
import com.sample.entity.EstimateProductDetailUpdateDTO;
import com.sample.entity.EstimateProductDetailsDTO;
import com.sample.entity.EstimateProductDetailsDTO1;
import com.sample.entity.EstimateResponseDTO;
import com.sample.entity.EstimateUpdateDTO;
import com.sample.entity.EstimateWithoutTaxDTO;
import com.sample.entity.EstimateWithoutTaxResponseDTO;
import com.sample.entity.EstimateWithoutTaxUpdateDTO;
import com.sample.entity.Estimateproductdetails;
import com.sample.entity.Estimatewithouttax;
import com.sample.entity.EstimatewithouttaxDTO1;
import com.sample.repository.CustomerRepository;
import com.sample.repository.EstimateRepository;
import com.sample.repository.EstimateproductdetailsRepository;
import com.sample.repository.EstimatewithouttaxRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstimateService {

    @Autowired
    private EstimateRepository estimateRepository;
    
    @Autowired
    private EstimateproductdetailsRepository estimateProductDetailsRepository;
    
    @Autowired
    private EstimatewithouttaxRepository repository;
    
 
    @Autowired
    private CustomerRepository customerRepository;
    
    
    @Transactional
    public Estimate addEstimate(EstimateDTO estimateDTO) {
        Estimate estimate = new Estimate();
        // Set all Estimate fields from DTO
        estimate.setOrdertype(estimateDTO.getOrdertype());
        estimate.setCustomerdisplayname_id(estimateDTO.getCustomerdisplayname_id());
        estimate.setEmail(estimateDTO.getEmail());
        estimate.setCc(estimateDTO.getCc());
        estimate.setBcc(estimateDTO.getBcc());
        estimate.setBillto(estimateDTO.getBillto());
        estimate.setShipto(estimateDTO.getShipto());
        estimate.setAcceptedby(estimateDTO.getAcceptedby());
        estimate.setEstimatedate(estimateDTO.getEstimatedate());
        estimate.setStatus_id(estimateDTO.getStatus_id());
        estimate.setFranchiseowner_id(estimateDTO.getFranchiseowner_id());
        
        estimate.setCreateddate(estimateDTO.getCreateddate());
        estimate.setCity_id(estimateDTO.getCity_id());
        estimate.setState_id(estimateDTO.getState_id());
        
        estimate.setSubtotal(estimateDTO.getSubtotal());
        estimate.setDiscount(estimateDTO.getDiscount());
        estimate.setTaxablesubtotal(estimateDTO.getTaxablesubtotal());
        estimate.setTaxrates_id(estimateDTO.getTaxrates_id());
        estimate.setSalestax(estimateDTO.getSalestax());
        estimate.setTotal(estimateDTO.getTotal());
        estimate.setPaycheckto(estimateDTO.getPaycheckto());
        estimate.setNotetocustomer(estimateDTO.getNotetocustomer());
        estimate.setInternalcustomernotes(estimateDTO.getInternalcustomernotes());
        estimate.setMemoonstatement(estimateDTO.getMemoonstatement());
        
        // Set the customer based on the customerdisplayname_id
        String customerDisplayName = estimateDTO.getCustomerdisplayname_id();
        Customer customer = customerRepository.findBycustomerdisplayname(customerDisplayName);
        if (customer != null) {
            estimate.setCustomer(customer);  // Set the customer entity in the invoice
        } else {
            throw new IllegalArgumentException("Customer with display name " + customerDisplayName + " not found");
        }
        
        List<Estimateproductdetails> productDetailsList = new ArrayList<>();
        for (EstimateProductDetailsDTO productDTO : estimateDTO.getEstimateProductDetails()) {
            Estimateproductdetails productDetails = new Estimateproductdetails();
            productDetails.setProductid(productDTO.getProductid());
            productDetails.setName(productDTO.getName());
            productDetails.setDescription(productDTO.getDescription());
            productDetails.setQty(productDTO.getQty());
            productDetails.setSalesprice(productDTO.getSalesprice());
            productDetails.setAmount(productDTO.getAmount());
            productDetails.setSalestaxes_id(productDTO.getSalestaxes_id());
            productDetails.setEstimate(estimate);
            productDetailsList.add(productDetails);
        }

        estimate.setEstimateProductDetails(productDetailsList);
        // Map EstimateWithoutTaxDTO to Estimatewithouttax entities
        List<Estimatewithouttax> withoutTaxList = new ArrayList<>();
        for (EstimateWithoutTaxDTO withoutTaxDTO : estimateDTO.getEstimateWithoutTax()) {
            Estimatewithouttax withoutTax = new Estimatewithouttax();
            withoutTax.setDescriptionwot(withoutTaxDTO.getDescriptionwot());
            withoutTax.setPricewot(withoutTaxDTO.getPricewot());
            withoutTax.setEstimate(estimate);
            withoutTaxList.add(withoutTax);
        }
        estimate.setEstimateWithoutTax(withoutTaxList);

        return estimateRepository.save(estimate);
    }
    

    public List<Estimate> getAllEstimates() {
        return estimateRepository.findAll();
    }

    public EstimateResponseDTO getEstimateById(Long id) {
        Estimate estimate = estimateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estimate not found with id " + id));

        EstimateResponseDTO responseDTO = new EstimateResponseDTO();
        responseDTO.setId(estimate.getId());
        responseDTO.setOrdertype(estimate.getOrdertype());
        responseDTO.setCustomerdisplayname_id(estimate.getCustomerdisplayname_id());
        responseDTO.setEmail(estimate.getEmail());
        responseDTO.setCc(estimate.getCc());
        responseDTO.setBcc(estimate.getBcc());
        responseDTO.setBillto(estimate.getBillto());
        responseDTO.setShipto(estimate.getShipto());
        responseDTO.setAcceptedby(estimate.getAcceptedby());
        responseDTO.setEstimatedate(estimate.getEstimatedate());
        responseDTO.setStatus_id(estimate.getStatus_id());
        responseDTO.setFranchiseowner_id(estimate.getFranchiseowner_id());
        
        responseDTO.setCreateddate(estimate.getCreateddate());
        responseDTO.setCity_id(estimate.getCity_id());
        responseDTO.setState_id(estimate.getState_id());
        
        responseDTO.setSubtotal(estimate.getSubtotal());
        responseDTO.setDiscount(estimate.getDiscount());
        responseDTO.setTaxablesubtotal(estimate.getTaxablesubtotal());
        responseDTO.setTaxrates_id(estimate.getTaxrates_id());
        responseDTO.setSalestax(estimate.getSalestax());
        responseDTO.setTotal(estimate.getTotal());
        responseDTO.setPaycheckto(estimate.getPaycheckto());
        responseDTO.setNotetocustomer(estimate.getNotetocustomer());
        responseDTO.setInternalcustomernotes(estimate.getInternalcustomernotes());
        responseDTO.setMemoonstatement(estimate.getMemoonstatement());

        responseDTO.setEstimateProductDetails(
                estimate.getEstimateProductDetails().stream().map(product -> {
                    EstimateProductDetailResponseDTO productDTO = new EstimateProductDetailResponseDTO();
                    productDTO.setId(product.getId());
                    productDTO.setProductid(product.getProductid());
                    productDTO.setName(product.getName());
                    productDTO.setDescription(product.getDescription());
                    productDTO.setQty(product.getQty());
                    productDTO.setSalesprice(product.getSalesprice());
                    productDTO.setAmount(product.getAmount());
                    productDTO.setSalestaxes_id(product.getSalestaxes_id());
                    return productDTO;
                }).collect(Collectors.toList())
        );

     // Map EstimateWithoutTax to DTO
        responseDTO.setEstimateWithoutTax(
                estimate.getEstimateWithoutTax().stream().map(wot -> {
                    EstimateWithoutTaxResponseDTO wotDTO = new EstimateWithoutTaxResponseDTO();
                    wotDTO.setId(wot.getId());
                    wotDTO.setDescriptionwot(wot.getDescriptionwot());
                    wotDTO.setPricewot(wot.getPricewot());
                    return wotDTO;
                }).collect(Collectors.toList())
        );

        return responseDTO;
    }
   
    @Transactional
    public Estimate updateEstimate(EstimateUpdateDTO estimateUpdateDTO) {
        Estimate estimate = estimateRepository.findById(estimateUpdateDTO.getId())
                .orElseThrow(() -> new RuntimeException("Estimate not found with id " + estimateUpdateDTO.getId()));

        // Update Estimate fields
        estimate.setOrdertype(estimateUpdateDTO.getOrdertype());
        estimate.setCustomerdisplayname_id(estimateUpdateDTO.getCustomerdisplayname_id());
        estimate.setEmail(estimateUpdateDTO.getEmail());
        estimate.setCc(estimateUpdateDTO.getCc());
        estimate.setBcc(estimateUpdateDTO.getBcc());
        estimate.setBillto(estimateUpdateDTO.getBillto());
        estimate.setShipto(estimateUpdateDTO.getShipto());
        estimate.setAcceptedby(estimateUpdateDTO.getAcceptedby());
        estimate.setEstimatedate(estimateUpdateDTO.getEstimatedate());
        estimate.setStatus_id(estimateUpdateDTO.getStatus_id());
        estimate.setFranchiseowner_id(estimateUpdateDTO.getFranchiseowner_id());
        
        estimate.setCreateddate(estimateUpdateDTO.getCreateddate());
        estimate.setCity_id(estimateUpdateDTO.getCity_id());
        estimate.setState_id(estimateUpdateDTO.getState_id());
        
        estimate.setSubtotal(estimateUpdateDTO.getSubtotal());
        estimate.setDiscount(estimateUpdateDTO.getDiscount());
        estimate.setTaxablesubtotal(estimateUpdateDTO.getTaxablesubtotal());
        estimate.setTaxrates_id(estimateUpdateDTO.getTaxrates_id());
        estimate.setSalestax(estimateUpdateDTO.getSalestax());
        estimate.setTotal(estimateUpdateDTO.getTotal());
        estimate.setPaycheckto(estimateUpdateDTO.getPaycheckto());
        estimate.setNotetocustomer(estimateUpdateDTO.getNotetocustomer());
        estimate.setInternalcustomernotes(estimateUpdateDTO.getInternalcustomernotes());
        estimate.setMemoonstatement(estimateUpdateDTO.getMemoonstatement());

        // Update or add Estimateproductdetails
        List<Estimateproductdetails> existingDetails = estimate.getEstimateProductDetails();
        existingDetails.clear();  // Remove all existing details to avoid orphaned records
        
        for (EstimateProductDetailUpdateDTO productDTO : estimateUpdateDTO.getEstimateProductDetails()) {
            Estimateproductdetails productDetail = new Estimateproductdetails();
            productDetail.setId(productDTO.getId());
            productDetail.setProductid(productDTO.getProductid());
            productDetail.setName(productDTO.getName());
            productDetail.setDescription(productDTO.getDescription());
            productDetail.setQty(productDTO.getQty());
            productDetail.setSalesprice(productDTO.getSalesprice());
            productDetail.setAmount(productDTO.getAmount());
            productDetail.setSalestaxes_id(productDTO.getSalestaxes_id());
            productDetail.setEstimate(estimate);

            existingDetails.add(productDetail); // Add or update details list
        }
        
     // Update or add Estimatewithouttax details
        List<Estimatewithouttax> existingWithoutTaxDetails = estimate.getEstimateWithoutTax();
        existingWithoutTaxDetails.clear(); // Remove all existing without-tax details to avoid orphaned records

        for (EstimateWithoutTaxUpdateDTO withoutTaxDTO : estimateUpdateDTO.getEstimateWithoutTax()) {
            Estimatewithouttax withoutTaxDetail = new Estimatewithouttax();
            withoutTaxDetail.setId(withoutTaxDTO.getId());
            withoutTaxDetail.setDescriptionwot(withoutTaxDTO.getDescriptionwot());
            withoutTaxDetail.setPricewot(withoutTaxDTO.getPricewot());
            withoutTaxDetail.setEstimate(estimate);

            existingWithoutTaxDetails.add(withoutTaxDetail); // Add or update without-tax details list
        }

        return estimateRepository.save(estimate);
    }
    public void deleteEstimate(Long id) {
        estimateRepository.deleteById(id);
    }
    
    // Method to fetch the Estimate details by ID
    public EstimateDTO1 getEstimateDetails(Long estimateId) {
        Optional<Estimate> estimateOptional = estimateRepository.findById(estimateId);
        if (!estimateOptional.isPresent()) {
            return null; // Or throw an exception if needed
        }

        Estimate estimate = estimateOptional.get();
        EstimateDTO1 estimateDTO = new EstimateDTO1();
        estimateDTO.setId(estimate.getId());
        estimateDTO.setOrdertype(estimate.getOrdertype());
        estimateDTO.setCustomerdisplayname_id(estimate.getCustomerdisplayname_id());
        estimateDTO.setCreateddate(estimate.getCreateddate());
        estimateDTO.setBillto(estimate.getBillto());
        estimateDTO.setSubtotal(estimate.getSubtotal());
        estimateDTO.setSalestax(estimate.getSalestax());
        estimateDTO.setTotal(estimate.getTotal());
        estimateDTO.setNotetocustomer(estimate.getNotetocustomer());

        List<EstimateProductDetailsDTO1> productDetailsDTOList = estimate.getEstimateProductDetails().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        estimateDTO.setEstimateProductDetails(productDetailsDTOList);
        
        List<EstimatewithouttaxDTO1> estimateWithoutTaxDTOList = estimate.getEstimateWithoutTax().stream().map(this::convertToDTO).collect(Collectors.toList());
        estimateDTO.setEstimateWithoutTax(estimateWithoutTaxDTOList);

        return estimateDTO;
    }

    // Convert Estimateproductdetails entity to DTO
    private EstimateProductDetailsDTO1 convertToDTO(Estimateproductdetails productDetails) {
        EstimateProductDetailsDTO1 dto = new EstimateProductDetailsDTO1();
        dto.setId(productDetails.getId());
//        dto.setProductid(productDetails.getProductid());
        dto.setName(productDetails.getName());
        dto.setDescription(productDetails.getDescription());
        dto.setQty(productDetails.getQty());
        dto.setSalesprice(productDetails.getSalesprice());
        dto.setAmount(productDetails.getAmount());
        return dto;
    }
    
    private EstimatewithouttaxDTO1 convertToDTO(Estimatewithouttax taxes) {
    	EstimatewithouttaxDTO1 dtos = new EstimatewithouttaxDTO1();
    	dtos.setId(taxes.getId());
        dtos.setDescriptionwot(taxes.getDescriptionwot());
        dtos.setPricewot(taxes.getPricewot());
        return dtos;
    }
    
 // Display List of All Estimate Particular Fields - Estimate Report
    public List<EstimateDTO2> getAllEstimates1() {
        List<Estimate> estimates = estimateRepository.findAll();
        return estimates.stream()
                .map(estimate -> new EstimateDTO2(
                        estimate.getId(),
                        estimate.getOrdertype(),
                        estimate.getCustomerdisplayname_id(),
                        estimate.getStatus_id(),
                        estimate.getCreateddate(),
                        estimate.getFranchiseowner_id()
                ))
                .collect(Collectors.toList());
    }
}
