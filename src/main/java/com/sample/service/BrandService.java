package com.sample.service;

import com.sample.entity.Brand;
import com.sample.entity.BrandDTO;
import com.sample.entity.BrandDTO1;
import com.sample.entity.BrandDTO2;
import com.sample.entity.User;
import com.sample.repository.BrandRepository;
import com.sample.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;
    
    @Autowired
    private UserRepository userRepository;
    
   
    
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }


    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Optional<Brand> getBrandById(Long id) {
        return brandRepository.findById(id);
    }

   

    public Brand updateBrand(Long id, Brand updatedBrand) {
        Optional<Brand> existingBrand = brandRepository.findById(id);
        if (existingBrand.isPresent()) {
            Brand brand = existingBrand.get();
            brand.setName(updatedBrand.getName());
            return brandRepository.save(brand);
        } else {
            return null;
        }
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
    
    //  to display only brandname and id
    public List<BrandDTO> getAllBrandNamesAndIds() {
        List<Brand> brands = brandRepository.findAllBy();
        return brands.stream()
                     .map(brand -> new BrandDTO(brand.getId(), brand.getName()))
                     .collect(Collectors.toList());
    }
    
    // to dispaly brandnames based on userid
    public List<BrandDTO1> getAccessibleBrands(Long userId) {
        return brandRepository.findBrandsByUserId(userId);
    }
    
    // To Display All Brand Details 
    public List<BrandDTO2> getAllBrandDetails() {
        return brandRepository.findAll()
                .stream()
                .map(brand -> new BrandDTO2(
                        brand.getId(),
                        brand.getName(),
                        brand.getBrandaddress(),
                        brand.getSalesrep1title(),
                        brand.getSalesrep1firstname(),
                        brand.getSalesrep1lastname(),
                        brand.getSalesrep1mobilenumber(),
                        brand.getSalesrep1emailid(),
                        brand.getSalesrep2title(),
                        brand.getSalesrep2firstname(),
                        brand.getSalesrep2lastname(),
                        brand.getSalesrep2mobilenumber(),
                        brand.getSalesrep2emailid()
                ))
                .collect(Collectors.toList());
    }
    
    
}
