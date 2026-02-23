package com.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sample.entity.Company;
import com.sample.entity.CompanyDTO;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    
    @Query("SELECT new com.sample.entity.CompanyDTO(c.id, c.name, c.address) FROM Company c")
    List<CompanyDTO> findAllCompanyDetails();
}